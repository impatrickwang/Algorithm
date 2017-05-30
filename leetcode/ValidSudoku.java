public class Solution {
    // 23:22
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] b = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] > '9' || board[i][j] < '1') continue;
                if (b[board[i][j]-'1']) return false;
                b[board[i][j]-'1'] = true;
            }
        }
        
        for (int i = 0; i < 9; i++) {
            boolean[] b = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] > '9' || board[j][i] < '1') continue;
                if (b[board[j][i]-'1']) return false;
                b[board[j][i]-'1'] = true;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] b = new boolean[9];
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[m+i*3][n+j*3] > '9' || board[m+i*3][n+j*3] < '1') continue;
                        if (b[board[m+i*3][n+j*3]-'1']) return false;
                        b[board[m+i*3][n+j*3]-'1'] = true;
                    }
                }
            }
        }

        return true;
    }
}
