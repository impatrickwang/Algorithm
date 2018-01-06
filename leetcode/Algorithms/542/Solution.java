class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (matrix[i][j] == 1) res[i][j] = -1;
                else queue.add(new int[]{i, j});
            }
        }
        int[][] dir = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int cnt = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll(0);
                for (int j = 0; j < 4; j++) {
                    int x = p[0]+dir[j][0];
                    int y = p[1]+dir[j][1];
                    if (x >= 0 && x < res.length && y >= 0 && y < res[0].length && res[x][y] < 0) {
                        res[x][y] = cnt;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            cnt++;
        }
        return res;
    }
}
