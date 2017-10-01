class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Integer> map = new HashMap<>();
        TreeSet<Long> set = new TreeSet<>();
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i-l > k) {
                if (map.get((long)nums[l]) == 1) {
                    map.remove((long)nums[l]);
                    set.remove((long)nums[l]);
                } else map.put((long)nums[l], map.get((long)nums[l])-1);
                l++;
            }
            Long ceil = set.ceiling((long)nums[i]-t);
            Long floor = set.floor((long)nums[i]+t);
            if (ceil != null && ceil <= nums[i] || floor != null && floor >= nums[i]) return true;
            if (!map.containsKey((long)nums[i])) {
                map.put((long)nums[i], 1);
                set.add((long)nums[i]);
            } else map.put((long)nums[i], map.get((long)nums[i])+1);
        }
        return false;
    }
}
