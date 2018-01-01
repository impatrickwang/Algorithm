class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i * 2 <= s.length(); i++) {
            if (s.length() % i == 0) {
                boolean f = true;
                for (int j = 0; j < i; j++) {
                    for (int k = 1; k < s.length()/i; k++) {
                        if (s.charAt(j) != s.charAt(j+k*i)) {
                            f = false;
                            break;
                        }
                    }
                    if (!f) break;
                }
                if (f) return true;
            }
        }
        return false;
    }
}
