class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                long sum = ((long) C[i])+D[j];
                if (!map.containsKey(sum)) map.put(sum, 0);
                map.put(sum, map.get(sum)+1);
            }
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                long sum = ((long) A[i])+B[j];
                if (map.containsKey(0-sum)) res += map.get(0-sum);
            }
        }
        return res;
    }
}
