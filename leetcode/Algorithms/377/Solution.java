class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        return solve(nums, target, map);
    }

    private int solve(int[] nums, int t, Map<Integer, Integer> map) {
        if (t == 0) return 1;
        if (map.containsKey(t)) return map.get(t);
        int res = 0;
        for (int i = 0; i < nums.length && nums[i] <= t; i++) {
            res += solve(nums, t-nums[i], map);
        }
        map.put(t,res);
        return res;
    }
}
