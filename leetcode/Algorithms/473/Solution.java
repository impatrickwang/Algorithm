class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % 4 != 0) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1-i; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = nums[i];
        }
        return solve(nums, new int[4], 0, sum/4);
    }

    private boolean solve(int[] nums, int[] sums, int index, int target) {
        if (index >= nums.length) {
            if (sums[0] == target && sums[1] == target && sums[2] == target) return true;
            else return false;
        }
        for (int i = 0; i < 4; i++) {
            sums[i] += nums[index];
            if (sums[i] <= target && solve(nums, sums, index+1, target)) return true;
            sums[i] -= nums[index];
        }
        return false;
    }
}
