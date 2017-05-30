public class Solution {
    public int reverse(int x) {
        long y = x;
        if (x < 0) y = -y;
        long z = 0;
        while (y > 0) {
            z = z*10 + y % 10;
            y /= 10;
        }
        if (x < 0) z = -z;
        if (z > Integer.MAX_VALUE || z < Integer.MIN_VALUE) z = 0;
        return (int) z;
    }
}
