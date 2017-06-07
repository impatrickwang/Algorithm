/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
	// 22:47
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((i1, i2) -> {
            if (i1.start < i2.start) return -1;
            else if (i1.start > i2.start) return 1;
            else if (i1.end < i2.end) return -1;
            else if (i1.end > i2.end) return 1;
            return 0;});
        List<Interval> res = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            while (i+1 < intervals.size() && end >= intervals.get(i+1).start) {
                i++;
                end = Math.max(end, intervals.get(i).end);
            }
            res.add(new Interval(start, end));
        }
        return res;
    }
}
