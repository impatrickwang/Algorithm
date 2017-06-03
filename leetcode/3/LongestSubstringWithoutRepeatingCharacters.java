import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) start = map.get(s.charAt(i)) + 1;
            else result = Math.max(result, i - start + 1);
            map.put(s.charAt(i), i);
        }
        return result;
    }
}
