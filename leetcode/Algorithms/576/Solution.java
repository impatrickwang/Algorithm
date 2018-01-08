class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N < 1) return 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int[][][] cnts = new int[N+1][m][n];
        cnts[0][i][j] = 1;
        cnts[N][i][j] = 1;
        int[][] dir = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int t = 0; t < N-1; t++) {
            int size = queue.size();
            boolean[][] used = new boolean[m][n];
            for (; size > 0; size--) {
                int[] p = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int x = p[0]+dir[k][0];
                    int y = p[1]+dir[k][1];
                    if (x >= 0 && y >= 0 && x < m && y < n) {
                        cnts[t+1][x][y] = (cnts[t+1][x][y] + cnts[t][p[0]][p[1]]) % 1_000_000_007;
                        cnts[N][x][y] = (cnts[N][x][y] + cnts[t+1][p[0]][p[1]]) % 1_000_000_007;
                        if (!used[x][y]) {
                            queue.add(new int[] {x, y});
                            used[x][y] = true;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int k = 0; k < m; k++) res = (res + (cnts[N][k][0] + cnts[N][k][n-1]) % 1_000_000_007) % 1_000_000_007;
        for (int k = 0; k < n; k++) res = (res + (cnts[N][0][k] + cnts[N][m-1][k]) % 1_000_000_007) % 1_000_000_007;
        return res;
    }
}
