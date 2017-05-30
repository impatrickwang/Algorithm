public class Solution {
    // 22:48
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) return 0;
        int cur = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) continue;
            nums[len++] = nums[i];
            cur = nums[i];
        }
        return len;
    }
}
