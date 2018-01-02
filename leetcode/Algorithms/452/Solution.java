class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length < 1) return 0;
        Arrays.sort(points, (p1, p2) -> p1[0] != p2[0] ? p1[0] - p2[0] : p1[1] - p2[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] != p2[1] ? p1[1] - p2[1] : p1[0] - p2[0]);
        int res = 0;
        int min = -1;
        for (int i = 0; i < points.length; i++) {
            if (min < 0) min = i;
            if (points[i][0] > points[min][1]) {
                res++;
                min = i;
            } else if (points[i][1] < points[min][1]) min = i;
        }
        return ++res;
    }
}
