public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        long w = 5;
        while (w <= n) {
            res += n / w;
            w *= 5;
        }
        return res;
    }
}
