public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(max, nums[i]+i);
        }
        return true;
    }
}
