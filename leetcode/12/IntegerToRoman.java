public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[][] tab = new char[][] {
            {'I', 'V'},
            {'X', 'L'},
            {'C', 'D'},
            {'M'}};
        int i = 0;
        while (num > 0) {
            int x = num % 10;
            if (x < 4) for (int j = 0; j < x; j++) sb.insert(0, tab[i][0]);
            else if (x == 4) {
                sb.insert(0, tab[i][1]);
                sb.insert(0, tab[i][0]);
            } else if (x == 5) sb.insert(0, tab[i][1]);
            else if (x < 9) {
                for (int j = 0; j < x-5; j++) sb.insert(0, tab[i][0]);
                sb.insert(0, tab[i][1]);
            } else {
                sb.insert(0, tab[i+1][0]);
                sb.insert(0, tab[i][0]);
            }
            i++;
            num /= 10;
        }
        return sb.toString();
    }
}
