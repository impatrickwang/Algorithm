class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        long mm = m;
        long nn = n;
        long w = 1;
        int res = 0;
        for (int i = 0; i < 31; i++) {
            if (mm-nn <= w && nn % (2*w) >= w && mm % (2*w) >= w) res += w;
            w *= 2;
        }
        return res;
    }
}
