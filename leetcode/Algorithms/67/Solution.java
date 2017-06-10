public class Solution {
	// 20:51
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (int i = 0; a.length()-1-i >= 0 || b.length()-1-i >= 0; i++) {
            if (a.length()-1-i >= 0) c += a.charAt(a.length()-1-i) - '0';
            if (b.length()-1-i >= 0) c += b.charAt(b.length()-1-i) - '0';
            sb.append((char) (c%2 + '0'));
            c /= 2;
        }
        if (c > 0) sb.append((char) (c + '0'));
        return sb.reverse().toString();
    }
}
