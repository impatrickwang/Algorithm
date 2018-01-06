class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length < 1) return true;
        int[][] max = new int[nums.length][nums.length];
        int total = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            total = 0;
            for (int j = i; j < nums.length; j++) {
                total += nums[j];
                if (j == i) max[i][j] = total;
                else max[i][j] = total - Math.min(max[i+1][j], max[i][j-1]);
            }
        }
        return max[0][nums.length-1] >= (total % 2 == 0 ? total/2 : total/2 + 1);
    }
}
