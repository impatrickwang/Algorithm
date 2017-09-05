class Solution {
    public int singleNumber(int[] nums) {
        int m0 = 0;
        int m1 = 0;
        for (int i = 0; i < nums.length; i++) {
            m1 ^= m0 & nums[i];
            m0 ^= nums[i];
            int mask = ~(m1 & m0);
            m1 &= mask;
            m0 &= mask;
        }
        return m0 | m1;
    }
}
