class Solution {
    public int findMaxLength(int[] nums) {
        int[][] cnts = new int[100001][];
        int cnt = 0;
        cnts[50000] = new int[] {-1, -1};
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += (nums[i] == 1 ? 1:-1);
            int index = cnt+50000;
            if (cnts[index] == null) cnts[index] = new int[]{i, i};
            else {
                cnts[index][1] = i;
                res = Math.max(res, i-cnts[index][0]);
            }
        }
        return res;
    }
}
