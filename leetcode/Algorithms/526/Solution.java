class Solution {
    public int countArrangement(int N) {
        return solve(new boolean[N], N);
    }

    private int solve(boolean[] used, int pos) {
        if (pos == 0) return 1;
        int res = 0;
        for (int i = used.length; i > 0; i--) {
            if (!used[i-1]) {
                if (i % pos == 0 || pos % i == 0) {
                    used[i-1] = true;
                    res += solve(used, pos-1);
                    used[i-1] = false;
                }
            }
        }
        return res;
    }
}
