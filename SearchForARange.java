public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private int[] search(int[] nums, int target, int l, int h) {
        if (l > h) return new int[] {-1, -1};
        if (l == h && nums[l] == target) return new int[] {l, l};
        int m = (l+h)/2;
        if (nums[m] == target) {
            int[] left = search(nums, target, l, m-1);
            int[] right = search(nums, target, m+1, h);
            return new int[] {left[0] >= 0 ? left[0]:m, right[1] >= 0 ? right[1]:m};
        } else if (nums[m] < target) return search(nums, target, m+1, h);
        else return search(nums, target, l, m-1);
    }
}
