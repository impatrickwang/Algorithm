public class Solution {
    public void sortColors(int[] nums) {
      	int l = 0;
        int h = nums.length-1;
        for (int i = 0; i <= h; ) {
            if (nums[i] == 0) {
                swap(nums, i, l);
                i++
                l++;
            } else if (nums[i] == 2) {
                swap(nums, i, h);
                h--;
            } else i++;
        } 
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
