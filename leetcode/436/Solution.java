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
    public int[] findRightInterval(Interval[] intervals) {
        Map<Integer, List<Integer>> ends = new HashMap<>();
        int[] res = new int[intervals.length];
        int[][] starts = new int[intervals.length][];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = new int[]{intervals[i].start, i};
            if (!ends.containsKey(intervals[i].end)) ends.put(intervals[i].end, new ArrayList<Integer>());
            ends.get(intervals[i].end).add(i);
        }
        Arrays.sort(starts, (n1, n2) -> n1[0] - n2[0]);
        for (Map.Entry<Integer, List<Integer>> entry:ends.entrySet()) {
            int index = find(starts, entry.getKey());
            for (Integer i:entry.getValue()) {
                res[i] = index;
            }
        }
        return res;
    }

    private int find(int[][] starts, int key) {
        int l = 0;
        int h = starts.length-1;
        while (l < h) {
            int m = (l+h)/2;
            if (starts[m][0] == key) return starts[m][1];
            else if (starts[m][0] < key) l = m+1;
            else h = m;
        }
        if (starts[l][0] >= key) return starts[l][1];
        return -1;
    }
}
