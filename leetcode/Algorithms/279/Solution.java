class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            if (i == 0) dp[i] = 0;
            else {
                int min = dp[i-1] + 1;
                for (int j = 2; i-j*j >= 0; j++) {
                    if (dp[i-j*j]+1 < min) min = dp[i-j*j]+1;
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
