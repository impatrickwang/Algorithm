class Solution {
    public int missingNumber(int[] nums) {
        int miss = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 0 && nums[i] != i) {
                if (nums[i] == nums.length) nums[i] = -1;
                else {
                    int tmp = nums[i];
                    nums[i] = nums[tmp];
                    nums[tmp] = tmp;
                }
            }
            if (nums[i] < 0) miss = i;
        }
        return miss;
    }
}
