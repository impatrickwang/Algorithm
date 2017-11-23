class Solution {
    public int[] singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) a ^= nums[i];
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((a & 1) == 1) break;
            a = a >> 1;
            mask = mask << 1;
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mask) == 0) res[0] ^= nums[i];
            else res[1] ^= nums[i];
        }
        return res;
    }
}
