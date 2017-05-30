public class Solution {
	// 23:10
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; ) {
            if (nums[i] == val) {
                int temp = nums[--len];
                nums[len] = nums[i];
                nums[i] = temp;
            } else i++;
        }
        return len;
    }
}
