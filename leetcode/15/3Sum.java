public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
		for (int i = 0; i < nums.length-2; i++) {
			int l = i+1;
            int h = nums.length-1;
            while (l < h) {
                if (nums[i] + nums[l] + nums[h] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[h]);
                    lists.add(list);
                    do {
                        h--;
                    } while (l < h && nums[h] == nums[h+1]);
                    do {
                        l++;
                    } while (l < h && nums[l] == nums[l-1]);
                } else if (nums[i] + nums[l] + nums[h] > 0) {
                    do {
                        h--;
                    } while (l < h && nums[h] == nums[h+1]);
                } else {
                    do {
                        l++;
                    } while (l < h && nums[l] == nums[l-1]);
                }
            }
            while (i+1 < nums.length && nums[i+1] == nums[i]) {
                i++;
            }
        }
        return lists;
    }
}
