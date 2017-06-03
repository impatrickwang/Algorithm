public class Solution {
	// 12:00
    public int trap(int[] height) {
        if (height.length < 2) return 0;
        int l = 0;
        int h = height.length-1;
        int last = Math.min(height[l], height[h]);
        int res = last*(h-l-1);
        while (l+1 < h) {
            if (height[l] <= height[h]) {
                do {
                    l++;
                    res -= Math.min(last, height[l]);
                } while (l+1 < h && height[l] <= last);
            } else {
                do {
                    h--;
                    res -= Math.min(last, height[h]);
                } while (l+1 < h && height[h] <= last);
            }
            res += (Math.min(height[l], height[h]) - last)*(h-l-1);
            last = Math.min(height[l], height[h]);
        }
        return res;
    }
}
