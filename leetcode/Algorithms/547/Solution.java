class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                res++;
                dfs(M, visited, i);
            }
        }
        return res;
    }

    private void dfs(int[][] M, boolean[] v, int x) {
        v[x] = true;
        for (int i = 0; i < v.length; i++) {
            if (i != x && M[x][i] == 1 && !v[i]) {
                dfs(M, v, i);
            }
        }
    }
}
