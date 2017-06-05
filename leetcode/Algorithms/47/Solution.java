public class Solution {
    // 10:40
    public List<List<Integer>> permuteUnique(int[] nums) {
	Arrays.sort(nums);
        return permute(nums, new boolean[nums.length], nums.length);
    }

    private List<List<Integer>> permute(int[] nums, boolean[] used, int remain) {
	List<List<Integer>> res = new ArrayList<>();
	if (remain == 0) {
	    res.add(new ArrayList<Integer>());
	    return res;
	}
	int last = -1;
	for (int i = 0; i < nums.length; i++) {
	    if (last >= 0 && nums[last] == nums[i]) continue;
	    if (!used[i]) {
		used[i] = true;
		List<List<Integer>> lists = permute(nums, used, remain-1);
		for (List<Integer> list:lists) {
		    list.add(nums[i]);
		    res.add(list);
		}
		used[i] = false;
		last = i;
	    }
	}
	return res;
    }
}
