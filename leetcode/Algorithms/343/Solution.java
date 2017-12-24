class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) dp[i] = 1;
            else {
                int max = 0;
                for (int j = 1; j+j <= i; j++) 
                    max = Math.max(max, Math.max(dp[j], j)*Math.max(i-j, dp[i-j]));
                dp[i] = max;
            }
        }
        return dp[n];
    }
}
