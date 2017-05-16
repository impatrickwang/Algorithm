public class Solution {
    public List<String> generateParenthesis(int n) {
        return generate(n, n);
    }

    private List<String> generate(int x, int y) {
        List<String> res = new ArrayList<>();
        if (x == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < y; i++) sb.append(')');
            res.add(sb.toString());
        } else {
            List<String> list = generate(x-1, y);
            for (String s : list) res.add("("+s);
            if (x < y) {
                list = generate(x, y-1);
                for (String s : list) res.add(")"+s);
            }
        }
        return res;
    }
}
