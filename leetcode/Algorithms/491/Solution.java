class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> lists = solve(0, -101, nums);
        for (List<Integer> list:lists) if (list.size() > 1) res.add(list);
        return res;
    }

    private List<List<Integer>> solve(int si, int last, int[] nums) {
        if (si >= nums.length) return new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = si; i < nums.length; i++) {
            if (!set.contains(nums[i]) && nums[i] >= last) {
                List<List<Integer>> lists = solve(i+1, nums[i], nums);
                for (List<Integer> list:lists) {
                    list.add(0, nums[i]);
                }
                List<Integer> l = new ArrayList<>();
                l.add(nums[i]);
                lists.add(l);
                res.add(lists);
                set.add(nums[i]);
            }
        }
        return res;
    }
}
