class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length-1-i && nums[i] < nums[nums.length-1-i]; i++) {
            res += nums[nums.length-1-i] - nums[i];
        }
        return res;
    }
}
