public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return sum(candidates, target, 0);
    }

    private List<List<Integer>> sum(int[] candidates, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        if (start >= candidates.length || target < candidates[start]) return res;
        for (int i = 0; target-i*candidates[start] >= 0;i++) {
            List<List<Integer>> lists = sum(candidates, target - i * candidates[start], start+1);
            for (List<Integer> list:lists) {
                List<Integer> l = new ArrayList<>();
                for (int j = 0; j < i; j++) l.add(candidates[start]);
                for (Integer integer:list) l.add(integer);
                res.add(l);
            }
        }
        return res;
    }
}
