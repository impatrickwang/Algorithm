public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if (strs.length < 1) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = prefix(res, strs[i]);
        }
        return res;    
    }

    private String prefix(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }
}
