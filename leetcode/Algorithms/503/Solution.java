class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length < 1) return nums;
        List<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && nums[list.get(list.size()-1)] < nums[i]) {
                res[list.remove(list.size()-1)] = nums[i];
            }
            list.add(i);
        }
        int index = list.remove(0);
        res[index] = -1;
        while (!list.isEmpty() && nums[list.get(0)] == nums[index]) {
            res[list.remove(0)] = -1;
        }
        for (int i = 0; i <= index; i++) {
            while (!list.isEmpty() && nums[list.get(list.size()-1)] < nums[i]) {
                res[list.remove(list.size()-1)] = nums[i];
            }
        }
        return res;
    }
}
