class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += z & 1;
            z = z >> 1;
        }
        return res;
    }
}
