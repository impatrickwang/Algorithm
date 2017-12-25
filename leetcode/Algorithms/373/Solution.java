class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> nums1[n1[0]]+nums2[n1[1]]-nums1[n2[0]]-nums2[n2[1]]);
        List<int[]> res = new ArrayList<>();
        pq.add(new int[]{0, 0});
        k = Math.min(k, nums1.length*nums2.length);
        boolean[][] dup = new boolean[nums1.length][nums2.length];
        while (res.size() < k) {
            int[] index = pq.poll();
            res.add(new int[] {nums1[index[0]], nums2[index[1]]});
            if (index[0]+1 < nums1.length && !dup[index[0]+1][index[1]]) {
                pq.add(new int[] {index[0]+1, index[1]});
                dup[index[0]+1][index[1]] = true;
            }
            if (index[1]+1 < nums2.length && !dup[index[0]][index[1]+1]) {
                pq.add(new int[] {index[0], index[1]+1});
                dup[index[0]][index[1]+1] = true;
            }
        }
        return res;
    }
}
