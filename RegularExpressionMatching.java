public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[] pp = new boolean[p.length()];
        for (int i = 0; i < p.length(); i++) {
            pp[i] = true;
            if (p.charAt(i) == '*') pp[i-1] = false;
        }
        boolean[] totalLast = new boolean[p.length()+1];
        boolean[] lastLast = new boolean[p.length()+1];
        boolean[] last = new boolean[p.length()+1];
        boolean[] cur = new boolean[p.length()+1];
        last[0] = totalLast[0] = lastLast[0] = true;
        for (int i = 1; i < p.length()+1; i++) {
            if (pp[i-1] && p.charAt(i-1) != '*') {
                last[i] = totalLast[i] = lastLast[i] = false;
            } else {
                last[i] = totalLast[i] = lastLast[i] = last[i-1] && true;
            }
        }
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < p.length()+1; j++) {
                if (!pp[j-1]) continue;
                if (p.charAt(j-1) == '*') {
                    if (p.charAt(j-2) == '.') cur[j] = totalLast[j-2] || cur[j-2];
                    else if (p.charAt(j-2) != s.charAt(i-1)) cur[j] = cur[j-2];
                    else if (i > 1 && s.charAt(i-1) == s.charAt(i-2)) cur[j] = cur[j-2] || lastLast[j-2];
                    else cur[j] = cur[j-2] || last[j-2];
                } else if (p.charAt(j-1) == '.') cur[j] = last[j-1];
                else cur[j] = last[j-1] && s.charAt(i-1) == p.charAt(j-1); 
            }
            for (int j = 0; j < p.length()+1; j++) {
                totalLast[j] = totalLast[j] || cur[j];
                lastLast[j] = i >= 2 && s.charAt(i-1) == s.charAt(i-2) ? lastLast[j] || cur[j] : cur[j] || last[j];
                last[j] = cur[j];
            }
        }
        return last[p.length()];
    }
}
