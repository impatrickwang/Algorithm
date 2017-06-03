public class Solution {
	// 23:11
    public String countAndSay(int n) {
        StringBuilder str = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            char c = str.charAt(0);
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) == c) cnt++;
                else {
                    sb.append((char) (cnt+'0'));
                    sb.append(c);
                    c = str.charAt(j);
                    cnt = 1;
                }
            }
            sb.append((char) (cnt+'0'));
            sb.append(c);
            str = sb;
        }
        return str.toString();
    }
}
