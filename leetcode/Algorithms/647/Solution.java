class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i+l < s.length(); i++) {
                if (l == 0) dp[i][i+l] = true;
                else if (l == 1) dp[i][i+l] = s.charAt(i) == s.charAt(i+l);
                else dp[i][i+l] = dp[i+1][i+l-1] && s.charAt(i) == s.charAt(i+l);
                if (dp[i][i+l]) res++;
            }
        }
        return res;
    }
}
