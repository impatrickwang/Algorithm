class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int sum = 0;
        int res = 0;
        for (int h = 0; h < nums.length; h++) {
            sum += nums[h];
            while (sum >= s) {
                res = res == 0 ? (h-l+1) : Math.min(res, h-l+1);
                sum -= nums[l++];
            }
        }
        return res;
    }
}
