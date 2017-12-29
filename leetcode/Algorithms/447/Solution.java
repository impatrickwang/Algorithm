class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int x = points[i][0] - points[j][0];
                    int y = points[i][1] - points[j][1];
                    int len = x*x + y*y;
                    if (!map.containsKey(len)) map.put(len, 1);
                    else map.put(len, map.get(len)+1);
                }
            }
            for (Integer value:map.values()) res += value*(value-1);
        }
        return res;
    }
}
