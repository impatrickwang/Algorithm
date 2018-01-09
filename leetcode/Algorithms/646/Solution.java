class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1]-b[1]);
        int res = 0;
        int max = -1;
        for (int i = 0; i < pairs.length; i++) {
            if (res == 0 || pairs[i][0] > max) {
                res ++;
                max = pairs[i][1];
            }
        }
        return res;
    }
}
