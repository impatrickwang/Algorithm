class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && i+1 != nums[i] && nums[nums[i]-1] != nums[i]) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
            if (nums[i] > 0 && nums[i] != i+1) nums[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) if (nums[i] < 0) res.add(i+1);
        return res;
    }
}
