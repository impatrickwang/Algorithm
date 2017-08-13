public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length < 1) return 0;
        int max = 0;
        int min = 0;
        int maxi = -1;
        int mini = -1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = 0;
                min = 0;
                maxi = -1;
                mini = -1;
            } else if (nums[i] > 0) {
                if (mini >= 0) {
                    min = min * nums[i];
                }
                if (maxi >= 0) max *= nums[i];
                else {
                    max = nums[i];
                    maxi = i;
                }
            } else {
                int lmax = max;
                int lmaxi = maxi;
                if (mini >= 0) {
                    max = min * nums[i];
                    maxi = mini;
                } else {
                    max = 0;
                    maxi = -1;
                }
                if (lmaxi >= 0) {
                    min = lmax * nums[i];
                    mini = lmaxi;
                } else {
                    min = nums[i];
                    mini = i;
                }
            }
            if (maxi >= 0) res = Math.max(res, max);
            else res = Math.max(res, Math.max(min, nums[i]));
        }
        return res;
    }
}
