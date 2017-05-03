public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i+2 < nums.length; ) {
            int l = i+1;
            int h = nums.length-1;
            while (l < h) {
                int sum = nums[i] + nums[l] + nums[h];
                if (sum == target) return target;
                else if (sum < target) {
                    do {
                        l++;
                    } while (l < h && nums[l] == nums[l-1]);
                } else {
                    do {
                        h--;
                    } while (l < h && nums[h] == nums[h+1]);
                }
                res = Math.abs(sum - target) < Math.abs(res) ? sum - target : res;
            }
            do {
                i++;
            } while (i+2 < nums.length && nums[i] == nums[i-1]);
        }
        return target + res;
    }
}
