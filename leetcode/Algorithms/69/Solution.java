public class Solution {
	// 21:35
    public int mySqrt(int x) {
        return (int) sqrt(x, 0, x);
    }

    private long sqrt(int x, long l, long h) {
        if (l == h) {
            if (l*l <= x) return l;
            return l-1;
        }
        if (l+1 == h) {
            if (h*h <= x) return h;
            if (l*l <= x) return l;
            return l-1;
        }
        long m = (l+h) / 2;
        if (m*m == x) return m;
        else if (m*m < x) return sqrt(x, m+1, h);
        else return sqrt(x, l, m-1);
    }
}
