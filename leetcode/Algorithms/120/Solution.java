public class Solution {
	// 22:15
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] nums = new int[triangle.size()];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                int sum = triangle.get(i).get(j);
                if (j < i && j > 0) sum += Math.min(nums[j], nums[j-1]);
                else if (j < i) sum += nums[j];
                else if (j > 0) sum += nums[j-1];
                nums[j] = sum;
                if (j == i) res = nums[j];
                else res = Math.min(res, nums[j]);
            }
        }
        return res;
    }
}
