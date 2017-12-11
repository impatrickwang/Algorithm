class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dir = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < dir.length; k++) {
                    int x = i+dir[k][0];
                    if (x < 0 || x >= m) continue;
                    int y = j+dir[k][1];
                    if (y < 0 || y >= n) continue;
                    if (board[x][y] == 1 || board[x][y] == -2) cnt++;
                    if (cnt > 3) break;
                }
                if (board[i][j] == 0 && cnt == 3) board[i][j] = -1;
                else if (board[i][j] == 1 && (cnt < 2 || cnt > 3)) board[i][j] = -2;
            }
        }
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++)
                if (board[i][j] < 0) board[i][j] += 2;
    }
}
