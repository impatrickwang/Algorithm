class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String s:strs) {
            int[] cnts = new int[2];
            for (int i = 0; i < s.length(); i++) {
                cnts[s.charAt(i)-'0']++;
            }
            for (int i = m; i-cnts[0] >= 0; i--) {
                for (int j = n; j-cnts[1] >= 0; j--) {
                    dp[i][j] = Math.max(1+dp[i-cnts[0]][j-cnts[1]], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
}
