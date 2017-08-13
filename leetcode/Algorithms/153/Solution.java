public class Solution {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length-1);
    }

    private int find(int[] nums, int l, int h) {
        if (l == h) return nums[l];
        if (nums[l] < nums[h]) return nums[l];
        int m = (l+h) / 2;
        if (nums[m] >= nums[l]) return find(nums, m+1, h);
        else return find(nums, l, m);
    }
}
