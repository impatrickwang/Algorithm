class Solution {
    public boolean isUgly(int num) {
        if (num < 1) return false;
        int[] factors = new int[]{2, 3, 5};
        for (int i = 0; i < factors.length; i++) {
            while (num % factors[i] == 0) {
                num /= factors[i];
            }
        }
        return num == 1;
    }
}
