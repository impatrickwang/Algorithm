public class Solution {
    // 16:20
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
	while (i - 1 >= 0 && nums[i-1] >= nums[i]) {
	    i--;
	}
	int l = i;
	int h = nums.length-1;
	while (l < h) {
	    swap(nums, l, h);
	    l++;
	    h--;
	}
	if (i > 0) {
	    int j = i-1;
	    while (nums[i] <= nums[j]) {
		i++;
	    }
	    swap(nums, i, j);
	}
    }

    private void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
    }
}
