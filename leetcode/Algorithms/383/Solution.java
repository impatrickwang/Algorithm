class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] cnts = new char[26];
        for (int i = 0; i < magazine.length(); i++) cnts[magazine.charAt(i)-'a']++;
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--cnts[ransomNote.charAt(i)-'a'] < 0) return false;
        }
        return true;
    }
}
