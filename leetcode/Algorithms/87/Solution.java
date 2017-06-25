public class Solution {
	// 11:53
    public boolean isScramble(String s1, String s2) {
        if (s1.length() < 1 || s2.length() < 1 || s1.length() != s2.length()) return false;
        return solve(s1, 0, s1.length(), s2, 0, s2.length());
    }

    private boolean solve(String s1, int l1, int h1, String s2, int l2, int h2) {
        if (h1-l1 == 1) return s1.charAt(l1) == s2.charAt(l2);
        boolean res = false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        Map<Character, Integer> map3 = new HashMap<>();
        for (int i = 1; i < h1-l1; i++) {
			map1.putIfAbsent(s1.charAt(l1+i-1), 0);
            map1.put(s1.charAt(l1+i-1), map1.get(s1.charAt(l1+i-1))+1);
            map2.putIfAbsent(s2.charAt(l2+i-1), 0);
            map2.put(s2.charAt(l2+i-1), map2.get(s2.charAt(l2+i-1))+1);
            map3.putIfAbsent(s2.charAt(h2-i), 0);
            map3.put(s2.charAt(h2-i), map3.get(s2.charAt(h2-i))+1);
            res = solve(s1, l1, l1+i, s2, l2, l2+i) && solve(s1, l1+i, h1, s2, l2+i, h2) || solve(s1, l1, l1+i, s2, h2-i, h2) && solve(s1, l1+i, h1, s2, l2, h2-i);
            if (res) break;
        }
        return res;
    }
}
