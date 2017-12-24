class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        int w = 1;
        while (true) {
            for (int i = 0; i < w; i++) {
                if (i+w > num) return res;
                res[i+w] = res[i]+1;
            }
            w *= 2;
        }
    }
}
