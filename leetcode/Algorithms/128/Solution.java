public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], 0);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int cnt = 1;
                int l = 1;
                while (map.containsKey(nums[i]-l)) {
                    cnt++;
                    map.remove(nums[i]-l);
                    l++;
                }
                l = 1;
                while (map.containsKey(nums[i]+l)) {
                    cnt++;
                    map.remove(nums[i]+l);
                    l++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
