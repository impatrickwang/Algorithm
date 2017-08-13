public class Solution {
    static int[][] dir = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void solve(char[][] board) {
	    int m = board.length;
        if (m < 1) return;
        int n = board[0].length;
        if (n < 1) return;    
		boolean[][] so = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m-1 || j == 0 || j == n-1) && board[i][j] == 'O') search(board, so, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !so[i][j]) board[i][j] = 'X';
            }
        }     
    }
    private void search(char[][] board, boolean[][] so, int i, int j) {
        if (so[i][j]) return;
        Queue<Integer> q = new LinkedList<>();
        so[i][j] = true;
        q.add(i); q.add(j);
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < dir.length; k++) {
                int a = x+dir[k][0];
                int b = y+dir[k][1];
                if (a >= 0 && a < board.length && b >= 0 && b < board[0].length && board[a][b] == 'O' && !so[a][b]) {
                    so[a][b] = true;
                    q.add(a);
                    q.add(b);
                }
            }
        }
    }
}
