class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int f = 0;
        int res = 1;
        int last = -1;
        for (int i = 1; i < nums.length; i++) {
            if (f == 0) {
                if (nums[i] == nums[i-1]) continue;
                if (nums[i] > nums[i-1]) f = 1;
                else f = -1;
            } else {
                if (nums[i] == nums[last]) continue;
                int cur = nums[i] > nums[last] ? 1 : -1;
                if (f == cur) {
                    last = i;
                    continue;
                }
                f = cur;
            }
            last = i;
            res++;
        }
        return res;
    }
}
