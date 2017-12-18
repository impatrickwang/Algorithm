class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map1.containsKey(nums1[i])) map1.put(nums1[i], 1);
            else map1.put(nums1[i], map1.get(nums1[i])+1);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey(nums2[i])) {
                if (!map2.containsKey(nums2[i])) map2.put(nums2[i], 0);
                if (map2.get(nums2[i]) < map1.get(nums2[i])) {
                    map2.put(nums2[i], map2.get(nums2[i])+1);
                    cnt++;
                }
            }
        }
        int[] res = new int[cnt];
        cnt = 0;
        for (Map.Entry<Integer, Integer> entry:map2.entrySet())
            for (int i = 0; i < entry.getValue(); i++) res[cnt++] = entry.getKey();
        return res;
    }
}
