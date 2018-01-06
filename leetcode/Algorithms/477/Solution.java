class Solution {
    public int totalHammingDistance(int[] nums) {
        int mask = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & mask) == 0) cnt++;
            }
            res += cnt * (nums.length-cnt);
            mask = mask << 1;
        }
        return res;
    }
}
