public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] indices = new int[4];
        for (indices[0] = 0; indices[0]+3 < nums.length; ) {
            for (indices[1] = indices[0]+1; indices[1]+2 < nums.length; ) {
                indices[2] = indices[1]+1;
                indices[3] = nums.length-1;
                while (indices[2] < indices[3]) {
                    int sum = nums[indices[0]] + nums[indices[1]] + nums[indices[2]] + nums[indices[3]];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        for (int k = 0; k < 4; k++) list.add(nums[indices[k]]);
                        res.add(list);
                    }
                    if (sum <= target) {
                        do {
                            indices[2]++;
                        } while (indices[2] < indices[3] && nums[indices[2]] == nums[indices[2]-1]);
                    }
                    if (sum >= target) {
                        do {
                            indices[3]--;
                        } while (indices[2] < indices[3] && nums[indices[3]] == nums[indices[3]+1]);
                    }
                }
                do {
                    indices[1]++;
                } while (indices[1]+2 < nums.length && nums[indices[1]] == nums[indices[1]-1]);
            }
            do {
                indices[0]++;
            } while (indices[0]+3 < nums.length && nums[indices[0]] == nums[indices[0]-1]);
        }
        return res;
    }
}
