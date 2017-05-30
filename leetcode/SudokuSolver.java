public class Solution {
	// 22:29
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int i, int j) {
        if (i > 8) return true;
        if (board[i][j] != '.') return solve(board, (i*9+j+1)/9, (i*9+j+1)%9);
        for (int k = 1; k < 10; k++) {
            board[i][j] = (char) (k+'0');
            if (conflict(board, i, j)) continue;
            if (solve(board, (i*9+j+1)/9, (i*9+j+1)%9)) return true;
        }
        board[i][j] = '.';
        return false;
    }

    private boolean conflict(char[][] board, int i, int j) {
        boolean[] b = new boolean[9];
        for (int m = 0; m < 9; m++) {
            if (board[i][m] != '.' && b[board[i][m]-'1']) return true;
            if (board[i][m] != '.') b[board[i][m]-'1'] = true;
        }

        b = new boolean[9];
        for (int m = 0; m < 9; m++) {
            if (board[m][j] != '.' && b[board[m][j]-'1']) return true;
            if (board[m][j] != '.') b[board[m][j]-'1'] = true;
        }

        b = new boolean[9];
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                if (board[i/3*3+m][j/3*3+n] != '.' && b[board[i/3*3+m][j/3*3+n]-'1']) return true;
                if (board[i/3*3+m][j/3*3+n] != '.') b[board[i/3*3+m][j/3*3+n]-'1'] = true;
            }
        }
        return false;
    }
}
