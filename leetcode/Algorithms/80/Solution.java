public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) return 0;
        int cur = nums[0];
        int l = 1;
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur && size < 2) {
                swap(nums, i, l);
                size++;
                l++;
            } else if (nums[i] != cur) {
                cur = nums[i];
                size = 1;
                swap(nums, i, l);
                l++;
            }
        }
        return l;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
