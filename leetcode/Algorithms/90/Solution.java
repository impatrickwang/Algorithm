public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return solve(nums, 0);
    }

    private List<List<Integer>> solve(int[] nums, int s) {
        List<List<Integer>> res = new ArrayList<>();
        if (s >= nums.length) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        int ns = s+1;
        while (ns < nums.length && nums[ns] == nums[s]) {
            ns++;
        }
        List<List<Integer>> lists = solve(nums, ns);
        for (List<Integer> list : lists) {
            for (int l = 0; l <= ns-s; l++) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                for (int i = 0; i < l; i++) newList.add(nums[s]);
                res.add(newList);
            }
        }
        return res;
    }
}
