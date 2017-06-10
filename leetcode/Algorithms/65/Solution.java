public class Solution {
	// 19:00
    public boolean isNumber(String s) {
        int[][] ss = new int[][] {
            {0,1,2,3,9,9},
            {9,9,2,3,9,9},
            {8,9,2,4,5,9},
            {9,9,4,9,9,9},
            {8,9,4,9,5,9},
            {9,6,7,9,9,9},
            {9,9,7,9,9,9},
            {8,9,7,9,9,9},
            {8,9,9,9,9,9}};
        int status = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') status = ss[status][0];
            else if (s.charAt(i) == '+' || s.charAt(i) == '-') status = ss[status][1];
            else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') status = ss[status][2];
            else if (s.charAt(i) == '.') status = ss[status][3];
            else if (s.charAt(i) == 'e') status = ss[status][4];
            else status = ss[status][5];
            if (status == 9) return false;
        }
        if (status == 2 || status == 4 || status == 7 || status == 8) return true;
        return false;
    }
}
