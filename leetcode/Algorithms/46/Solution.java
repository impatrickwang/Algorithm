public class Solution {
	// 22:54
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, new boolean[nums.length], nums.length);
    }

    private List<List<Integer>> permute(int[] nums, boolean[] used, int remain) {
        List<List<Integer>> res = new ArrayList<>();
        if (remain == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                List<List<Integer>> lists = permute(nums, used, remain-1);
                for (List<Integer> list:lists) {
                    list.add(nums[i]);
                    res.add(list);
                }
                used[i] = false;
            }
        }
        return res;
    }
}
