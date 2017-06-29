public class Solution {
	// 23:29
    public int numTrees(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] += dp[j-0]*dp[i-j];
            }
        }
        return dp[n];
    }
}
