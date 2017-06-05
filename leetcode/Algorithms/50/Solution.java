public class Solution {
	// 22:12
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            if (n % 2 == 0) return myPow(1/(x*x), -(n/2));
            else return myPow(1/x, -n);
        }
        if (n % 2 == 0) return myPow(x*x, n/2);
        else return x*myPow(x, n-1);
    }
}
