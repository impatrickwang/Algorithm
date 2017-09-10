class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int size = wordList.size();
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> used = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (oneDistance(beginWord, wordList.get(i))) {
                queue.add(wordList.get(i));
                map.put(wordList.get(i), 2);
                used.add(wordList.get(i));
            } else map.put(wordList.get(i), 0);
        }

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize > 0) {
                String s = queue.remove();
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String p = String.valueOf(chars);
                        if (map.containsKey(p) && !used.contains(p)) {
                            queue.add(p);
                            used.add(p);
                            map.put(p, map.get(s)+1);
                        }
                    }
                    chars[i] = old;
                }
                qSize--;
            }
        }
        return map.containsKey(endWord) ? map.get(endWord) : 0;
    }

	private boolean oneDistance(String s, String p) {
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != p.charAt(i)) size++;
            if (size > 1) return false;
        }
        return size == 1;
    }
}
