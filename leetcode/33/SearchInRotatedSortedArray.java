public class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int l, int h) {
        if (l > h) return -1;
        int m = (l+h) / 2;
        if (nums[m] == target) return m;
        if (nums[m] < nums[h] && nums[m] > target) return search(nums, target, l, m-1);
        else if (nums[m] > nums[h] && nums[m] < target)  return search(nums, target, m+1, h);
        else {
           int res = search(nums, target, l, m-1);
           if (res >= 0) return res;
           return search(nums, target, m+1, h);
        }
    }
}
