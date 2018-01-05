class Solution {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') cnt++;
        }
        if (cnt == 0 || cnt == word.length()) return true;
        if (cnt == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') return true;
        return false;
    }
}
