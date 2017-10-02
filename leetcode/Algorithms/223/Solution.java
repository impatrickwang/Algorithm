class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (int) (((long) C-A)*((long) D-B) + ((long) G-E)*((long) H-F) - overlap(A, C, E, G)*overlap(B, D, F, H));
    }

    private long overlap(long a, long b, long c, long d) {
        if (b <= c || a >= d) return 0;
        return Math.min(d, b)-Math.max(a,c);
    }
}
