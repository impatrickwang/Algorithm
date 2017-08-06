public class Solution {
    // 22:00
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i+10 <= s.length(); i++) {
            if (!map.containsKey(s.substring(i, i+10))) map.put(s.substring(i, i+10), 0);
            else if (map.get(s.substring(i, i+10)) == 0) {
                res.add(s.substring(i, i+10));
                map.put(s.substring(i, i+10), 1);
            }
        }
        return res;
    }
}
