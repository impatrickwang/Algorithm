class Solution {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        int mask = 15;
        for (int i = 0; i < 8; i++) {
            int m = num & mask;
            if (m < 10) sb.append(m);
            else sb.append((char) ('a'+m-10));
            num = num >> 4;
        }
        String res = sb.reverse().toString();
        int s = 0;
        while (s < 7 && res.charAt(s) == '0') {
            s++;
        }
        return res.substring(s);
    }
}
