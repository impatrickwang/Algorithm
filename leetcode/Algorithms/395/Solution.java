class Solution {
    public int longestSubstring(String s, int k) {
        return solve(s, k, 0, s.length()-1);  
    }

    private int solve(String s, int k, int l, int h) {
        if (h - l + 1 < k) return 0;
        int[] cnts = new int[26];
        for (int i = l; i <= h; i++) {
            int index = s.charAt(i) - 'a';
            cnts[index]++;
        }
        int min = -1;
        for (int i = 0; i < 26; i++) {
            if (cnts[i] > 0 && (min < 0 || cnts[i] < cnts[min])) min = i;
        }
        if (cnts[min] >= k) return h-l+1;
        int last = l;
        int res = 0;
        for (int i = l; i <= h; i++) {
            if (s.charAt(i) - 'a' == min) {
                res = Math.max(res, solve(s, k, last, i-1));
                last = i+1;
            }
        }
        if (last <= h) res = Math.max(res, solve(s, k, last, h));
        return res;
    }
}
