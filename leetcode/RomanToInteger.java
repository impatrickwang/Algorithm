public class Solution {
    public int romanToInt(String s) {
        char[][] tab = new char[][] {
            {'I', 'V'},
            {'X', 'L'},
            {'C', 'D'},
            {'M', 'U'},
            {'W'}};
        int res = 0;
        int index = 0;
        int curIndex = 0;
        for (int i = 3; i >= 0; i--) {
            curIndex = s.indexOf(tab[i+1][0], index);
            if (curIndex >= index) {
                res = res * 10 + 9;
                index = ++curIndex;
                continue;
            }
            curIndex = s.indexOf(tab[i][1], index);
            if (curIndex > index) {
                res = res * 10 + 4;
                index = ++curIndex;
                continue;
            } else if (curIndex == index) {
                do {
                    curIndex++;
                } while (curIndex < s.length() && s.charAt(curIndex) == tab[i][0]);
                res = res * 10 + 4 + (curIndex - index);
                index = curIndex;
                continue;
            }
            curIndex = s.indexOf(tab[i][0], index);
            if (curIndex == index) {
                do {
                    curIndex++;
                } while (curIndex < s.length() && s.charAt(curIndex) == tab[i][0]);
                res = res * 10 + curIndex - index;
                index = curIndex;
                continue;
            }
            res *= 10;
        }
        return res;
    }
}
