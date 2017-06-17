public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }

    private List<List<Integer>> subsets(int[] nums, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n >= nums.length) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        List<List<Integer>> lists = subsets(nums, n+1);
        for (List<Integer> list:lists) {
            List<Integer> newList = new ArrayList<>();
            newList.add(nums[n]);
            for (int i = 0; i < list.size(); i++) newList.add(list.get(i));
            res.add(list);
            res.add(newList);
        }
        return res;
    }
}
