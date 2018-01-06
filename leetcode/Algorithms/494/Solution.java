class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[] sum = new int[2001];
        sum[1000] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] nsum = new int[2001];
            for (int j = 0; j < 2001; j++) {
                if (sum[j] > 0) {
                    nsum[j+nums[i]] += sum[j];
                    nsum[j-nums[i]] += sum[j];
                }
            }
            sum = nsum;
        }
        return (S < -1000 || S > 1000) ? 0 : sum[1000+S];
    }
}
