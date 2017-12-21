class Solution {
    public int longestPalindrome(String s) {
        boolean[] nums = new boolean[52];
        int cnt = 0;
        int index = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') index = s.charAt(i) - 'a';
            else index = s.charAt(i) - 'A' + 26;
            sum++;
            nums[index] = !nums[index];
            if (nums[index]) cnt++;
            else cnt--;
        }
        if (cnt <= 1) return sum;
        else return sum - (cnt-1);
    }
}
