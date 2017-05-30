public class Solution {
    public boolean isPalindrome(int x) {
    	if (x < 0) return false;
        if (x > 0 && x%10 == 0) return false;
		int y = 0;
        while (x >= y) {
            if (x == y || x/10 == y) return true;
            y = y*10 + x%10;
            x /= 10;
        }
        return false;    
    }
}
