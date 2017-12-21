class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int min = 0;
        int h = -1;
        for (int i = 1; i < nums.length; i++) {
            if (h < 0) {
                if (nums[i] > nums[min]) h = i;
                else if (nums[i] < nums[min]) min = i;
            } else {
                if (nums[i] < nums[min]) min = i;
                else if (nums[i] > nums[h]) return true;
                else if (nums[i] > nums[min] && nums[i] < nums[h]) h = i;
            }
        }
        return false;
    }
}
