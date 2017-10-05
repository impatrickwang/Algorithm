class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        Map<Integer, List<Integer>> events = new HashMap<>();
        List<Integer> times = new LinkedList<>();
        for (int i = 0; i < buildings.length; i++) {
            if (!events.containsKey(buildings[i][0])) times.add(buildings[i][0]);
            if (!events.containsKey(buildings[i][1])) times.add(buildings[i][1]);
            if (!events.containsKey(buildings[i][0])) events.put(buildings[i][0], new ArrayList<>());
            events.get(buildings[i][0]).add(i);
            if (!events.containsKey(buildings[i][1])) events.put(buildings[i][1], new ArrayList<>());
            events.get(buildings[i][1]).add(i); 
        }
        PriorityQueue<Integer> heights = new PriorityQueue<>((i, j) -> j - i);
        Map<Integer, Integer> hCnts = new HashMap<>();
        int curHeight = 0;
        times.sort((i, j) -> i - j);
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < times.size(); i++) {
            List<Integer> l = events.get(times.get(i));
            for (int j = 0; j < l.size(); j++) {
                int height = buildings[l.get(j)][2];
                if (buildings[l.get(j)][0] == times.get(i)) {
                    if (!hCnts.containsKey(height)) {
                        hCnts.put(height, 1);
                        heights.add(height);
                    } else hCnts.put(height, hCnts.get(height)+1);
                } else {
                    if (hCnts.get(height) == 1) {
                        hCnts.remove(height);
                        heights.remove(height);
                    } else hCnts.put(height, hCnts.get(height)-1);
                }
            }
            int newHeight = heights.isEmpty() ? 0 : heights.peek();
            if (curHeight != newHeight) res.add(new int[]{times.get(i), newHeight});
            curHeight = newHeight;
        }
        return res;
    }
}
