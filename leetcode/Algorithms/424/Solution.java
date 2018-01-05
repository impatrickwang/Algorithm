class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() < 1) return 0;
        int res = 1;
        int[] cnts = new int[26];
        for (int i = 0; i-1+res < s.length(); i++) {
            if (i-1 >= 0) cnts[s.charAt(i-1)-'A']--;
            cnts[s.charAt(i-1+res)-'A']++;
            while (i+res < s.length()) {
                cnts[s.charAt(i+res)-'A']++;
                if (res+1-max(cnts) <= k) res++;
                else {
                    cnts[s.charAt(i+res)-'A']--;
                    break;
                }
            }
        }
        return res;
    }

    private int max(int[] cnts) {
        int res = -1;
        for (int i = 0; i < cnts.length; i++) res = Math.max(res, cnts[i]);
        return res;
    }
}
