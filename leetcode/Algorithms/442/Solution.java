class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[nums[i]-1] != nums[i]) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            } 
            if (nums[i] > 0 && nums[i] == nums[nums[i]-1]) {
                res.add(nums[i]);
                nums[i] = -1;
            }
        }
        return res;
    }
}
