class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnts = new int[26];
        int target = 0;
        for (int i = 0; i < p.length(); i++) {
            int index = p.charAt(i) - 'a';
            if (cnts[index] == 0) target++;
            cnts[index]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i-p.length() >= 0) {
                int index = s.charAt(i-p.length())-'a';
                if (cnts[index] == 0) target++;
                if (++cnts[index] == 0) target--;
            }
            int index = s.charAt(i)-'a';
            if (cnts[index] == 0) target++;
            if (--cnts[index] == 0) target--;
            if (target == 0) res.add(i-p.length()+1);
        }
        return res;
    }
}
