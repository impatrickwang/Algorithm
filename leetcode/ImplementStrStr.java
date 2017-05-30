public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() < 1) return 0;
        int[] next = new int[needle.length()];
        for (int i = 0; i < needle.length(); i++) {
            if (i < 2) next[i] = i;
            else {
                int p = i-1;
                while (next[p] > 0) {
                    if (needle.charAt(next[p]) == needle.charAt(i)) {
                        next[i] = next[p] + 1;
                        break;
                    } else p = next[p] - 1;
                }
                if (next[i] == 0 && needle.charAt(i) == needle.charAt(0)) next[i] = 1;
            }
        }
        int len = 0;
        for (int i = 0; i+needle.length() <= haystack.length(); ) {
            while (len < needle.length() && haystack.charAt(i+len) == needle.charAt(len)) {
                len++;
            }
            if (len == needle.length()) return i;
            if (len == 0) i++;
            else {
                i += len - next[len-1];
                len = next[len-1];
            }
        }
        return -1;
    }
}
