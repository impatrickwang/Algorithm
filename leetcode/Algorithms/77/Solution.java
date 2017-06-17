public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k) return res;
        if (k == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        while (n >= k) {
            List<List<Integer>> lists = combine(n-1, k-1);
            for (List<Integer> list:lists) {
                list.add(n);
                res.add(list);
            }
            n--;
        }
        return res;    
    }
}
