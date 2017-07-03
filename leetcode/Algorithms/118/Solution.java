public class Solution {
	// 18:12
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);    
            if (i > 0) {
                for (int j = 0; j < i-1; j++) list.add(res.get(res.size()-1).get(j)+res.get(res.size()-1).get(j+1));
                list.add(1);
            }
            res.add(list);
        }
        return res;
    }
}
