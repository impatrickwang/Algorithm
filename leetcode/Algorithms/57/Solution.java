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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        boolean used = false;
        for (int i = 0; i < intervals.size(); i++) {
            if (used) res.add(intervals.get(i));
            else {
                if (newInterval.start > intervals.get(i).end) res.add(intervals.get(i));
                else {
                    if (newInterval.end < intervals.get(i).start) {
                        res.add(newInterval);
                        res.add(intervals.get(i));
                    } else if (newInterval.end <= intervals.get(i).end) {
                        res.add(new Interval(Math.min(newInterval.start, intervals.get(i).start), intervals.get(i).end));
                    } else {
                        int start = Math.min(newInterval.start, intervals.get(i).start);
                        int end = Math.max(newInterval.end, intervals.get(i).end);
                        while (i+1 < intervals.size() && intervals.get(i+1).start <= end) {
                            i++;
                            end = Math.max(end, intervals.get(i).end);
                        }
                        res.add(new Interval(start, end));
                    }
                    used = true;
                }
            }
        }
        if (!used) res.add(newInterval);
        return res;
    }
}
