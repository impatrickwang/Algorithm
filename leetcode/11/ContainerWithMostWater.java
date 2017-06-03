public class Solution {
	//15.03
    public int maxArea(int[] height) {
        int l = 0;
        int h = height.length-1;
        int max = (h-l) * Math.min(height[l], height[h]);
        int start = 0;
        while (l < h) {
            if (height[l] <= height[h]) {
                start = height[l];
                while (l < h && height[l] <= start) {
                    l++;
                }
            } else {
                start = height[h];
                while (l < h && height[h] <= start) {
                    h--;
                }
            }
            max = Math.max(max, (h-l) * Math.min(height[l], height[h]));
        }
        return max;
    }
}
