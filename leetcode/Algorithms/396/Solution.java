class Solution {
    public int maxRotateFunction(int[] A) {
        int max = -1;
        int last = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                for (int j = 0; j < A.length; j++) {
                    last += j * A[j];
                    sum += A[j];
                }
                max = last;
            } else {
                last = last + sum - A.length * A[A.length-i];
                max = Math.max(last, max);
            }
        }
        return max;
    }
}
