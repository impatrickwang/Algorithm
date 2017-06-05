public class Solution {
	// 22:29
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        solve(new boolean[n][n], new boolean[n], 0, res);
        return res;
    }

    private void solve(boolean[][] board, boolean[] used, int row, List<List<String>> res) {
        if (row >= board.length) {
            res.add(convert(board));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                boolean conflict = false;
                for (int j = 0; j < row && j < i; j++) {
                    if (board[row-1-j][i-1-j]) {
                        conflict = true;
                        break;
                    }
                }
                for (int j = 0; row-1-j >= 0 && i+1+j < used.length; j++) {
                    if (board[row-1-j][i+1+j]) {
                        conflict = true;
                        break;
                    }
                }
                if (!conflict) {
                    used[i] = true;
                    board[row][i] = true;
                    solve(board, used, row+1, res);
                    used[i] = false;
                    board[row][i] = false;
                }
            }
        }
    }

    private List<String> convert(boolean[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) sb.append('Q');
                else sb.append('.');
            }
            res.add(sb.toString());
        }
        return res;
    }
}
