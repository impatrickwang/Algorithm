public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
		int r = 1;
        int l = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & r) != 0) res ^= l;
            r = r << 1;
            l = l >>> 1;
        }
        return res;        
    }
}
