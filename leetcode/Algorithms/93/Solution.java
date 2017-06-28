public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return solve(s, 0, 0);
    }

    private List<String> solve(String s, int start, int pos) {
        List<String> res = new ArrayList<>();
        if (pos >= 3) {
            if (s.length()-start <= 3 && s.length()-start > 0) {
                if (s.charAt(start) == '0') {
                    if (s.length()-start == 1) res.add("0");
                } else if (Integer.parseInt(s.substring(start)) < 256) res.add(s.substring(start));
            }
            return res;
        }
        int sum = 0;
        for (int i = 0; i < 3 && start+i < s.length(); i++) {
            sum = sum*10 + s.charAt(start+i) - '0';
            if (sum < 256) {
                List<String> list = solve(s, start+i+1, pos+1);
                for (String str:list) res.add(sum+"."+str);
                if (sum == 0) break;
            } else break;
        }
        return res;
    }
}
