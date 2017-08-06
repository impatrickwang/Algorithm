public class Solution {
	// 21:13
    public int rob(int[] nums) {
        if (nums.length < 1) return 0;
		int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
           if (i == 0) dp[i] = nums[i];
           else if (i == 1) dp[i] = Math.max(nums[i], dp[i-1]);
           else dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1]; 
    }
}
