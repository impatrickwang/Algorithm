public class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num2.length(); i++) {
            while (sb.length() < i+1) {
                sb.append('0');
            }
            for (int j = 0; j < num2.charAt(num2.length()-1-i) - '0'; j++) {
                int c = 0;
                for (int k = 0; k < num1.length(); k++) {
                    int a = num1.charAt(num1.length()-1-k) - '0';
                    if (sb.length() > i+k) a += sb.charAt(i+k) - '0';
                    a += c;
                    if (sb.length() > i+k) sb.setCharAt(i+k, (char) ((a%10)+'0'));
                    else sb.append((char) ((a%10)+'0'));
                    c = a/10;
                }
                int index = i+num1.length();
                while (c > 0) {
                    if (index < sb.length()) {
                        c += sb.charAt(index) - '0';
                        sb.setCharAt(index, (char) ((c%10)+'0'));
                    } else sb.append((char) ((c%10)+'0'));
                    c /= 10;
                }
            }
        }
        while (sb.length() > 1 && sb.charAt(sb.length()-1) == '0') {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();
    }
}
