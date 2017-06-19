public class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    private boolean search(int[] nums, int l, int h, int target) {
        if (l > h) return false;
        int m = (l+h)/2;
        if (nums[m] == target) return true;
        if (nums[l] == nums[h]) {
            if (nums[m] == nums[l] || nums[m] < nums[h] && target > nums[m] || nums[m] > nums[l] && target < nums[m]) return search(nums, l, m-1, target) || search(nums, m+1, h, target);
            else if (nums[m] < nums[h] && target < nums[m]) return search(nums, l, m-1, target);
            else return search(nums, m+1, h, target);
        } else {
            if (nums[m] <= nums[h] && target > nums[m] || nums[m] >= nums[l] && target < nums[m]) return search(nums, l, m-1, target) || search(nums, m+1, h, target);
            else if (nums[m] <= nums[h] && target < nums[m]) return search(nums, l, m-1, target);
            else return search(nums, m+1, h, target);
        }
    }
}
