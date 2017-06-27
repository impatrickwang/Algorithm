public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if (n == 0) return res;
        int w = 1;
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = size-1; j >= 0; j--) res.add(res.get(j)+w);
            w += w;
        }
        return res;
    }
}
