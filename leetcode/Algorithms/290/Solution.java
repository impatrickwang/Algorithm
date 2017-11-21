class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = new String[26];
        String[] splits = str.split(" ");
        if (pattern.length() != splits.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            int index = pattern.charAt(i) - 'a';
            if (strs[index] == null) strs[index] = splits[i];
            else if (!strs[index].equals(splits[i])) return false;
        }
        Set<String> set = new HashSet<>();
        for (String s:strs) {
            if (s != null) {
                if (set.contains(s)) return false;
                else set.add(s);
            }
        }
        return true;
    }
}
