class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> sizes = new HashSet<>();
        Map<Integer, Set<String>> map = new HashMap<>();
        for (String word:wordDict) {
            sizes.add(word.length());
            if (!map.containsKey(word.length())) map.put(word.length(), new HashSet<>());
            map.get(word.length()).add(word);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (Integer size:sizes) {
                if (i+1-size >= 0 && dp[i+1-size] && map.get(size).contains(s.substring(i+1-size, i+1))) {
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
