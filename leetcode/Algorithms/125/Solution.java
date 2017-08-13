public class Solution {
	// 23:00
    public boolean isPalindrome(String s) {
        int l = 0;
        int h = s.length()-1;
        while(l < h) {
            while (l < h && !fit(s.charAt(l))) {
                l++;
            }
            while (l < h && !fit(s.charAt(h))) {
                h--;
            }
            if (l < h && !same(s.charAt(l), s.charAt(h))) return false;
            l++;
            h--;
        }
        return true;
    }

    private boolean fit(char c) {
        return isA(c) || isN(c);
    }

    private boolean isA(char c) {
        return c >= 'A' && c <='Z' || c >= 'a' && c <= 'z';
    }

    private boolean isN(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean same(char c1, char c2) {
        if (isN(c1) && isN(c2)) return c1 == c2;
        if (isA(c1) && isA(c2)) return c1 == c2 || (char) (c1+32) == c2 || (char) (c1-32) == c2;
        return false;
    }
}
