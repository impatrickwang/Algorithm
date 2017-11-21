class Solution {
    public void moveZeroes(int[] nums) {
        int len = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                if (i != len) {
                    nums[len] = nums[i];
                    nums[i] = 0;
                }
                len++;
            }
            i++;
        }
    }
}
