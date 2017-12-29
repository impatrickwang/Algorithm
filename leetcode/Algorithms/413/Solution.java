class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int s = 0;
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if (i-s < 2 || A[i] - A[i-1] == A[i-1] - A[i-2]) continue;
            else {
                int cnt = i-s;
                res += cnt >= 3 ? (cnt-1) * (cnt-2) / 2:0;
                s = i-1;
            }
        }
        int cnt = A.length - s;
        res += cnt >= 3 ? (cnt-1) * (cnt-2) / 2:0;
        return res;        
    }
}
