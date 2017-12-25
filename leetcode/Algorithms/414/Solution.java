class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                if (pq.size() < 3) pq.add(nums[i]);
                else if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.add(nums[i]);
                }
                set.add(nums[i]);
            }
        }
        if (pq.size() == 2) pq.poll();
        return pq.poll();
    }
}
