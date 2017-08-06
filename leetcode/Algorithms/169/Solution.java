public class Solution {
    public int majorityElement(int[] nums) {
		int cand = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                cand = nums[i];
                cnt = 1;
            } else if (cand == nums[i]) cnt++;
            else cnt--;
        }
        return cand;
    }
}
