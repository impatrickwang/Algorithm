public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        int g = gcb(nums.length, k);
        int t = nums.length / g;
        for (int i = 0; i < nums.length/k; i++) {
            int tmp = nums[i];
            for (int j = 1; j <= t; j++) {
                int tmp2 = nums[(i+j*k)%nums.length];
                nums[(i+j*k)%nums.length] = tmp;
                tmp = tmp2;
            }
        }
    }

    private int gcb(int m, int n) {
        while (m % n != 0) {
            int r = m % n;
            m = n;
            n = r;
        }
        return n;
    }
}
