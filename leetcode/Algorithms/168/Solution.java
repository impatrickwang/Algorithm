public class Solution {
    public String convertToTitle(int n) {
	    long m = n;
        StringBuilder res = new StringBuilder();
        while (m > 0) {
            res.append((char) (((m+25) % 26) + 'A'));
            m = (m-1)/26;
        }
        return res.reverse().toString();
    }
}
