public class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (i+1 < nums.length && nums[i] > nums[i+1] || i+1 >= nums.length) return i;
            } else if (i == nums.length-1) {
                if (i-1 >= 0 && nums[i] > nums[i-1] || i-1 < 0) return i;
            } else if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
        }
        return -1;
    }
}
