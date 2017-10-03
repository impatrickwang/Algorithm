class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        return find(s, set, new HashMap<String, List<String>>());
    }

    private List<String> find(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        if ("".equals(s)) {
            res.add("");
            return res;
        }
        for (String word:wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = find(s.substring(word.length()), wordDict, map);
                for (String sub:subList) {
                    res.add(word+("".equals(sub)?"":" ")+sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
