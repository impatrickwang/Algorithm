public class Solution {
	// 23:11
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int acc = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, Math.max(acc+nums[i], nums[i]));
            acc = Math.max(acc+nums[i], nums[i]);
        }
        return max;
    }
}
