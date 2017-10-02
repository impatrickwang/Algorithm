class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<List<Integer>> ll = summaryRanges(nums, 0, nums.length-1);
        List<String> res = new ArrayList<>();
        for (List<Integer> l:ll) {
            if (l.get(0).equals(l.get(1))) res.add(l.get(0)+"");
            else res.add(l.get(0)+"->"+l.get(1));
        }
        return res;
    }

    private List<List<Integer>> summaryRanges(int[] nums, int l, int h) {
        List<List<Integer>> res = new ArrayList<>();
        if (l > h) return res;
        if (l == h || h - l == nums[h] - nums[l]) {
            List<Integer> ll = new ArrayList<>();
            ll.add(nums[l]);
            ll.add(nums[h]);
            res.add(ll);
            return res;
        }
        int m = (l+h)/2;
        res = summaryRanges(nums, l, m);
        List<List<Integer>> ll = summaryRanges(nums, m+1, h);
        if (res.get(res.size()-1).get(1) + 1 == ll.get(0).get(0)) {
            res.get(res.size()-1).remove(1);
            res.get(res.size()-1).add(ll.get(0).get(1));
            ll.remove(0);
        }
        res.addAll(ll);
        return res;
    }
}
