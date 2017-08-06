public class Solution {
    static int[][] d = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m < 1) return 0;
        int n = grid[0].length;
        if (n < 1) return 0;
        boolean[][] b = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !b[i][j]) {
                    bfs(grid, b, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, boolean[][] b, int i, int j) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i); q.add(j);
        b[i][j] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int xx = x+d[k][0];
                int yy = y+d[k][1];
                if (xx >= 0 && xx < b.length && yy >= 0 && yy < b[0].length && grid[xx][yy] == '1' && !b[xx][yy]) {
                    b[xx][yy] = true;
                    q.add(xx);
                    q.add(yy);
                }
            }
        }
    }
}
