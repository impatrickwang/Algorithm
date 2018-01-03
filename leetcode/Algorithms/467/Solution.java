class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p.length() < 1) return 0;
        int s = 0;
        int[] cnts = new int[26];
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == 'a' && p.charAt(i-1) == 'z' || p.charAt(i) == p.charAt(i-1)+1) continue;
            int start = p.charAt(s)-'a';
            for (int j = 0; j < Math.min(i-s, 26); j++) {
                int index = (start+j)%26;
                cnts[index] = Math.max(cnts[index], i-s-j);
            }
            s = i;
        }
        int start = p.charAt(s)-'a';
        for (int j = 0; j < Math.min(p.length()-s, 26); j++) {
            int index = (start+j)%26;
            cnts[index] = Math.max(cnts[index], p.length()-s-j);
        }
        int res = 0;
        for (int i = 0; i < 26; i++) res += cnts[i];
        return res;
    }
}
