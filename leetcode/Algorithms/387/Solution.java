class Solution {
    public int firstUniqChar(String s) {
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            if (index[j] == 0) index[j] = i+1;
            else if (index[j] > 0) index[j] = -1;
        }
        int res = -1;
        for (int i = 0; i < 26; i++) {
            if (res < 0) {
                if (index[i] > 0) res = index[i];
            } else if (index[i] > 0) res = Math.min(res, index[i]);
        }
        return res;
    }
}
