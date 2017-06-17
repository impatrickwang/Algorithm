public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) map.put(t.charAt(i), 0);
            map.put(t.charAt(i), map.get(t.charAt(i))+1);
        }
        int start = 0;
        int end = 0;
        int size = t.length();
        String res = "";
        while (end <= s.length()) {
            if (size > 0) {
                if (end < s.length() && map.containsKey(s.charAt(end))) {
                    if (map.get(s.charAt(end)) > 0) size--;
                    map.put(s.charAt(end), map.get(s.charAt(end))-1);
                }
                end++;
            } else {
                if ("".equals(res)) res = s.substring(start, end);
                else if (end - start < res.length()) res = s.substring(start, end);
                if (start < s.length() && map.containsKey(s.charAt(start))) {
                    if (map.get(s.charAt(start)) >= 0) size++;
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                }
                start++;
            }
        }
        return res;
    }
}
