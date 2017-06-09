public class Solution {
	// 15:11
    public String getPermutation(int n, int k) {
     	StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<Integer>();
        int w = 1;
        for (int i = 0; i < n; i++) {
            list.add(i+1);
            w *= i+1;
        }
        w /= n;
        k--;
        while (k > 0 && n > 1) {
            int index = k/w;
            sb.append((char)('0'+list.get(index)));
            list.remove(index);
            k = k % w;
            w /= (n-1);
            n--;
        }
        if (!list.isEmpty()) for (int i = 0; i < list.size(); i++) sb.append((char) ('0'+list.get(i)));
        return sb.toString();  
    }
}
