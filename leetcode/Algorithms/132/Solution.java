class Solution {
    public int minCut(String s) {
        boolean[][] b = new boolean[s.length()][s.length()];
        int[] cut = new int[s.length()];
        for (int j = 0; j < s.length(); j++) {
            int min = -1;
            for (int i = j; i >= 0; i--) {
                if (i == j || i+1 == j) b[i][j] = s.charAt(i) == s.charAt(j);
                else if (s.charAt(i) == s.charAt(j)) b[i][j] = b[i+1][j-1];
                if (b[i][j]) {
                    if (i == 0) min = 0;
                    else min = min == -1 ? cut[i-1]+1 : Math.min(min, cut[i-1]+1);
                }
            }
            cut[j] = min;
        }
        return cut[s.length()-1];
    }
}
