public class Solution {
	// 22:32
    public int jump(int[] nums) {
        if (nums.length < 2) return 0;
        int res = 1;
        int max = nums[0];
        int nMax = max;
        for (int i = 1; i < nums.length; i++) {
            if (max >= nums.length - 1) break;
            if (i > max) {
                max = nMax;
                nMax = max;
                res++;
            }
            nMax = Math.max(nMax, i+nums[i]);
        }
        return res;
    }
}
