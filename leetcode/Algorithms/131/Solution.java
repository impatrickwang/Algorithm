class Solution {
    public List<List<String>> partition(String s) {
        if (s.length() < 1) return new ArrayList<List<String>>();
        long start = System.currentTimeMillis();
        boolean[][] t = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j+i < s.length(); j++) {
                if (i == 0) t[j][j+i] = true;
                else if (i == 1) {
                    if (s.charAt(j) == s.charAt(j+i)) t[j][j+i] = true;
                } else if (s.charAt(j) == s.charAt(j+i) && t[j+1][j+i-1]) t[j][j+i] = true;
            }
        }
        return partition(s, 0, t);
    }
    
    private List<List<String>> partition(String s, int start, boolean[][] t) {
        List<List<String>> res = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (t[start][i]) {
                List<List<String>> ll = partition(s, i+1, t);
                String subs = s.substring(start, i+1);
                for (List<String> l:ll) l.add(0, subs);
                res.addAll(ll);
                if (ll.isEmpty()) {
                    List<String> l = new LinkedList<>();
                    l.add(subs);
                    res.add(l);
                }
            }
        }
        return res;
    }
}
