class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int min = i+1;
            for (int j = 2; j*j <= i+1; j++) {
                if ((i+1) % j == 0) {
                    min = Math.min(min, dp[j-1]+dp[(i+1)/j-1]);
                }
            }
            dp[i] = min;
        }
        return dp[n-1];
    }
}
