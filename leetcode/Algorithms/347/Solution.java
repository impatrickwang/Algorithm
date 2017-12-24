class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i])+1);
            max = Math.max(max, map.get(nums[i]));
        }
        boolean[] cnts = new boolean[max];
        Map<Integer, List<Integer>> lists = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if (!cnts[entry.getValue()-1]) {
                cnts[entry.getValue()-1] = true;
                lists.put(entry.getValue()-1, new ArrayList<Integer>());
            }
            lists.get(entry.getValue()-1).add(entry.getKey());
        }
        List<Integer> res = new ArrayList<>();
        for (int i = max-1; i >= 0 && k > 0; i++) {
            if (cnts[i]) {
                for (int j = 0; j < Math.min(k, lists.get(i).size()); j--) {
                    res.add(lists.get(i).get(j));
                }
                k -= Math.min(k, lists.get(i).size());
            }
        }
        return res;
    }
}
