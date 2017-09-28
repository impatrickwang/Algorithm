class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        return findMin(nums, l, h);
    }

    private int findMin(int[] nums, int l, int h) {
        if (l == h) return nums[l];
        if (l+1 == h) return Math.min(nums[l], nums[h]);
        if (nums[l] < nums[h]) return nums[l];
        int m = (l+h)/2;
        if (nums[l] == nums[h]) {
            if (nums[m] == nums[l]) return Math.min(findMin(nums, l, m-1), findMin(nums, m+1, h));
            else if (nums[m] > nums[l]) return findMin(nums, m+1, h);
            else return findMin(nums, l+1, m);
        } else {
            if (nums[m] >= nums[l]) return findMin(nums, m+1, h);
            else return findMin(nums, l+1, m);
        }
    }
}
