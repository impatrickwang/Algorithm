class Solution {
    private static final int[][] dir = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        List<int[]> res = new ArrayList<>();
        if (m < 1) return res;
        int n = matrix[0].length;
        boolean[][] ap = new boolean[m][n];
        solve(0, 0, ap, new boolean[m][n], matrix);
        boolean[][] aa = new boolean[m][n];
        solve(m-1, n-1, aa, new boolean[m][n], matrix);
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (ap[i][j] && aa[i][j]) res.add(new int[]{i, j});
        return res;
    }

    private void solve(int sx, int sy, boolean[][] access, boolean[][] used, int[][] matrix) {
        used[sx][sy] = true;
        List<int[]> queue = new LinkedList<>();
        access[sx][sy] = true;
        queue.add(new int[] {sx, sy});
        while (!queue.isEmpty()) {
            int[] p = queue.remove(0);
            int x = p[0];
            int y = p[1];
            for (int i = 0; i < dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length && !used[nx][ny]) {
                    if (nx == sx || ny == sy || matrix[x][y] <= matrix[nx][ny]) {
                        used[nx][ny] = true;
                        access[nx][ny] = true;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}
