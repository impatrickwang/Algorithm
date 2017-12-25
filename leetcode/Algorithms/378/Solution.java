class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> matrix[n1[0]][n1[1]] - matrix[n2[0]][n2[1]]);
        pq.add(new int[] {0, 0});
        int res = 0;
        int last = 0;
        for (int i = 0; i < k; i++) {
            int[] p = pq.poll();
            int x = p[0];
            int y = p[1];
            res = matrix[x][y];
            if (last < matrix.length-1 && x == last && y == 0) pq.add(new int[] {++last, 0});
            if (y + 1 < matrix.length) pq.add(new int[] {x, y+1});
        }
        return res;
    }
}
