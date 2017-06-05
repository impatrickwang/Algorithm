public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
	for (String str : strs) {
	    int[] nums = new int[26];
	    for (int i = 0; i < str.length(); i++) {
		nums[str.charAt(i)-'a'] += 1;
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < 26; i++) sb.append((char) ('0'+nums[i]));
	    String s = sb.toString();
	    if (!map.containsKey(s)) map.put(s, new ArrayList<String>());
	    map.get(s).add(str);
	}
	List<List<String>> res = new ArrayList<>();
	for (List<String> list:map.values()) res.add(list);
	return res;
    }
}
