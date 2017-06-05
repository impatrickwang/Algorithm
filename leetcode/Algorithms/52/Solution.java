public class Solution {
	// 22:57
    public int totalNQueens(int n) {
        return solve(new boolean[n][n], new boolean[n], 0);
    }
    
    private int solve(boolean[][] board, boolean[] used, int row) {
        if (row >= used.length) return 1;
        int res = 0;
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                boolean conflict = false;
                for (int j = 0; row-1-j >= 0; j++) {
                    if (i-1-j >= 0 && board[row-1-j][i-1-j]) {
                        conflict = true;
                        break;
                    }
                    if (i+1+j < used.length && board[row-1-j][i+1+j]) {
                        conflict = true;
                        break;
                    }
                }
                if (!conflict) {
                    used[i] = true;
                    board[row][i] = true;
                    res += solve(board, used, row+1);
                    used[i] = false;
                    board[row][i] = false;
                }
            }
        }
        return res;
    }
}
