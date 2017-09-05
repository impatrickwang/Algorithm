class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int s = 0;
        while (s < gas.length) {
            int r = gas[s] - cost[s];
            if (r >= 0) {
                int e = s+1;
                while (r >= 0 && e % gas.length != s) {
                    r += gas[e % gas.length] - cost[e % gas.length];
                    e++;
                }
                if (r >= 0 && e % gas.length == s) return s;
                s = e;
            } else s++;
        }
        return -1;
    }
}
