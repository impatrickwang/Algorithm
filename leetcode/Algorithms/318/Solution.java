class Solution {
    public int maxProduct(String[] words) {
        int[] nums = new int[words.length];
        int mask = 1;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                nums[i] = nums[i] | (mask << (words[i].charAt(j)-'a'));
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if ((nums[i] & nums[j]) == 0) res = Math.max(res, words[i].length()*words[j].length());
            }
        }
        return res;
    }
}
