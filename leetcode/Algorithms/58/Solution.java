public class Solution {
	// 12:25	
	public int lengthOfLastWord(String s) {
        int start = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') start = i+1;
            else res = i-start+1;
        }
        return res;    
	}
}
