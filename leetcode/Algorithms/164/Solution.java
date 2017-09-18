class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (max == min) return 0;
        int l = (max-min) / (nums.length-1);
        if (l < 1) l = 1;
        int c = (max-min) / l + 1;
        int[] mins = new int[c];
        int[] maxs = new int[c];
        for (int i = 0; i < c; i++) {
            mins[i] = -1;
            maxs[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i]-min)/l;
            mins[index] = mins[index] < 0 ? nums[i] : Math.min(mins[index], nums[i]);
            maxs[index] = maxs[index] < 0 ? nums[i] : Math.max(maxs[index], nums[i]);
        }
        int res = l;
        int s = 0;
        while (s < c && mins[s] < 0) {
            s++;
        }
        for (int i = s+1; i < c; i++) {
            if (mins[i] > 0) {
                res = Math.max(res, mins[i]-maxs[s]);
                s = i;
            }
        }
        return res;
    }
}
