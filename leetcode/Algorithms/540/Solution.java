class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        while (h-l+1 >= 3) {
            int m = (l+h)/2;
            if (nums[m] != nums[m-1] && nums[m] != nums[m+1]) return nums[m];
            else if (nums[m] == nums[m-1]) {
                if ((m-1-l) % 2 != 0) h = m-2;
                else l = m+1;
            } else {
                if ((m-l) % 2 != 0) h = m-1;
                else l = m+2;
            }
        }
        return nums[l];
    }
}
