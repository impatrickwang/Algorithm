public class Solution {
    public int divide(int dividend, int divisor) {
        long x = dividend;
	long y = divisor;
	x = x < 0 ? -x : x;
	y = y < 0 ? -y : y;
	if (x < y) return 0;
	long[] w = new long[33];
	long[] v = new long[33];
	w[0] = 1;
	v[0] = y;
	int i = 0;
	while (v[i] < x) {
	    i++;
    	    w[i] = w[i-1]+w[i-1];
	    v[i] = v[i-1]+v[i-1];
	}
	long res = 0;
	while (x > 0 && i >= 0) {
	    while (x >= v[i]) {
	        res += w[i];
		x -= v[i];
	    }
	    i--;
	}
	if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) res = -res;
	if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)res;
    }
}
