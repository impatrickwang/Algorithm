class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = Integer.MIN_VALUE;
        int m = Integer.MIN_VALUE;
        for (int i = 30; i >= 0; i--) {
            mask = mask >> 1;
            Set<Integer> set = new HashSet<>();
            for (int num:nums) set.add(num & mask);
            m = m >>> 1;
            int tmp = max | m;
            for (Integer prefix:set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
