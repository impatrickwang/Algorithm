public class Solution {
	// 20:43
    public int[] plusOne(int[] digits) {
        int c = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            c += digits[i];
            digits[i] = c % 10;
            c /= 10;
        }
        int[] res;
        if (c > 0) {
            res = new int[digits.length+1];
            res[0] = c;
        } else res = new int[digits.length];
        for (int i = 0; i < digits.length; i++) res[res.length-1-i] = digits[digits.length-1-i];
        return res;
    }
}
