class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int j = 0; j < coins.length; j++) {
                int n = i-coins[j] < 0 ? -1 : dp[i-coins[j]];
                if (n >= 0) min = min < 0 ? n : Math.min(n, min);
            }
            dp[i] = min < 0 ? min : min+1;
        }
        return dp[amount];
    }
}
