class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long last = -1;
        pq.add(1);
        int size = 0;
        while (size < n) {
            long o = pq.poll();
            if (o <= last) continue;
            last = o;
            size++;
            pq.add(last*2);
            pq.add(last*3);
            pq.add(last*5);
        }
        return (int) last;
    }
}
