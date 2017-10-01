class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(0, k, n);
    }

    private List<List<Integer>> combinationSum3(int from, int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (from > 9 || from > n || k <= 0) return res;
        if (k == 1) {
            if (n > 9) return res;
            List<Integer> l = new ArrayList<>();
            l.add(n);
            res.add(l);
            return res;
        }
        for (int i = from; i <= 9; i++) {
            List<List<Integer>> ll = combinationSum3(i+1, k-1, n-i);
            if (!ll.isEmpty()) 
                for (List<Integer> l:ll) {
                    l.add(i);
                    res.add(l);
                }
        }
        return res;
    }
}
