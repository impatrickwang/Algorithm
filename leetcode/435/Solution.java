/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length < 2) return 0;
        Arrays.sort(intervals, (i1, i2) -> i1.start != i2.start ? i1.start - i2.start : i1.end - i2.end);
        PriorityQueue<Interval> pq = new PriorityQueue<>((i1, i2) -> i1.end != i2.end ? i1.end-i2.end : i1.start-i2.start);
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (!pq.isEmpty() && pq.peek().end <= intervals[i].start) {
                pq.poll();
                res += pq.size();
                pq.clear();
            }
            pq.add(intervals[i]);
        }
        res += pq.size()-1;
        return res;
    }
}
