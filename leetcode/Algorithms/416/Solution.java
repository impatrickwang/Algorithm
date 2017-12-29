class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % 2 == 1) return false;
        int t = sum / 2;
        Arrays.sort(nums);
        return solve(0, t, nums, new int[nums.length][t+1]);
    }

    private boolean solve(int cur, int t, int[] nums, int[][] res) {
        if (t < 0 || cur >= nums.length) return false;
        if (t == 0) return true;
        if (res[cur][t] == 0) {
            for (int i = cur; i < nums.length && nums[i] <= t; i++) {
                if (solve(i+1, t-nums[i], nums, res)) {
                    res[cur][t] = 1;
                    break;
                }
            }
        }
        if (res[cur][t] == 0) res[cur][t] = -1;
        return res[cur][t] == 1;
    }
}
