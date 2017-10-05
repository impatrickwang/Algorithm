class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < 1 || k < 1) return new int[0];
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && q.peekFirst() == i-k) q.poll();
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.offerLast(i);
            if (i >= k-1) res[i-k+1] = nums[q.peekFirst()];
        }
        return res;
    }
}
