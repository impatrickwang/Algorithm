public class Solution {
	// 17:27
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) dp[i][j] = 1;
                else if (i == 0) dp[i][j] = 0;
                else if (j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + (s.charAt(i-1) == t.charAt(j-1) ? dp[i-1][j-1] : 0);
            }
        }
        return dp[m][n];
    }
}
