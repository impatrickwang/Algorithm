class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) if (!set.contains(nums1[i])) set.add(nums1[i]);
        Set<Integer> intersection = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) if (set.contains(nums2[i])) intersection.add(nums2[i]);
        Iterator<Integer> iter = intersection.iterator();
        int[] res = new int[intersection.size()];
        int l = 0;
        while (iter.hasNext()) {
            res[l++] = iter.next();
        }
        return res;
    }
}
