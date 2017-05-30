public class Solution {
    // 15:14
    public List<Integer> findSubstring(String s, String[] words) {
	List<Integer> res = new ArrayList<>();
	if (words.length < 1) return res;
	if (words[0].length() < 1) {
	    for (int i = 0; i <= s.length(); i++) res.add(i);
	    return res;
	}
	Map<String, Integer> sMap = new HashMap<>();
	for (int i = 0; i < words.length; i++) {
	    if (!sMap.containsKey(words[i])) sMap.put(words[i], 0);
	    sMap.put(words[i], sMap.get(words[i])+1);
	}
        for (int i = 0; i < words[0].length(); i++) {
	    Map<String, Integer> map = new HashMap<>();
	    int size = 0;
	    for (int j = i; j+words[0].length() <= s.length(); j+=words[0].length()) {
		String subStr = s.substring(j, j+words[0].length());
		if (!sMap.containsKey(subStr)) {
		    map = new HashMap<>();
		    size = 0;
		} else {
		    if (size >= words.length) {
			String repStr = s.substring(j-size*words[0].length(), j-(size-1)*words[0].length());
			map.put(repStr, map.get(repStr)-1);
			size--;
			if (map.get(repStr) == 0) map.remove(repStr);
		    }
		    if (!map.containsKey(subStr)) map.put(subStr, 0);
		    map.put(subStr, map.get(subStr)+1);
		    size++;
		    if (map.equals(sMap)) res.add(j-(size-1)*words[0].length());
		}
	    }
	}
	return res;
    }
}
