public class Solution {
	// 22:59
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }
    
    private int search(int[] nums, int target, int l, int h) {
        if (l > h) {
            if (h >= 0 && target < nums[h]) return h;
            if (h >= 0 && target > nums[h]) return h+1;
            if (l < nums.length && target < nums[l]) return l;
            if (l < nums.length && target > nums[l]) return l+1;
        }
        int m = (l+h)/2;
        if (nums[m] == target) return m;
        if (nums[m] < target) return search(nums, target, m+1, h);
        else return search(nums, target, l, m-1);
    }
}
