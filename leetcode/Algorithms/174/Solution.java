class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j == n-1) dp[i][j] = dungeon[i][j] < 0 ? 1-dungeon[i][j] : 1;
                else if (i == m-1) dp[i][j] = dp[i][j+1] - dungeon[i][j] > 0 ? dp[i][j+1] - dungeon[i][j] : 1;
                else if (j == n-1) dp[i][j] = dp[i+1][j] - dungeon[i][j] > 0 ? dp[i+1][j] - dungeon[i][j] : 1;
                else dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j] > 0 ? Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j] : 1;
            }
        }
        return dp[0][0];
    }
}
