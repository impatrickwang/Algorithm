class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (List<Integer> row:wall) {
            int mid = 0;
            for (int i = 0; i < row.size()-1; i++) {
                mid += row.get(i);
                if (!map.containsKey(mid)) map.put(mid, 0);
                map.put(mid, map.get(mid)+1);
                max = Math.max(max, map.get(mid));
            }
        }
        return wall.size()-max;
    }
}
