public class Solution {
    // 21:57
    public boolean isMatch(String s, String p) {
        boolean[] last = new boolean[p.length()+1];
        last[0] = true;
        boolean[] acc = new boolean[p.length()+1];
        acc[0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') last[i+1] = acc[i+1] = true;
            else break;
        }
        for (int i = 0; i < s.length(); i++) {
            boolean[] cur = new boolean[p.length()+1];
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '*') cur[j+1] = acc[j] || cur[j];
                else if (p.charAt(j) == '?') cur[j+1] = last[j];
                else if (last[j] && p.charAt(j) == s.charAt(i)) cur[j+1] = true;
            }
            last = cur;
            for (int k = 0; k <= p.length(); k++) acc[k] = acc[k] || cur[k];
        }
        return last[p.length()];
    }
}
