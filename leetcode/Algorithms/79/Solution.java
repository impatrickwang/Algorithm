public class Solution {
	// 22:39
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m < 1) return false;
        int n = board[0].length;
        if (n < 1) return false;
        if (n*m < word.length()) return false;
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (board[i][j] == word.charAt(0) && exist(board, i, j, word, 0, new boolean[m][n])) return true;
        return false;
    }

    private boolean exist(char[][] b, int i, int j, String w, int n, boolean[][] u, int[][][] r) {
        if (n >= w.length()) return true;
        if (i < 0 || i >= b.length || j < 0 || j >= b[0].length) return false;
        boolean res = false;
        if (!u[i][j] && b[i][j] == w.charAt(n)) {
            u[i][j] = true;
            res = exist(b, i+1, j, w, n+1, u) || exist(b, i-1, j, w, n+1, u) || exist(b, i, j+1, w, n+1, u) || exist(b, i, j-1, w, n+1, u);
            u[i][j] = false;
        }
        return res;
    }
}
