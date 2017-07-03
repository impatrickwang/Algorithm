public class Solution {
	// 18:22
    public List<Integer> getRow(int rowIndex) {
        int[] nums = new int[rowIndex+1];
        for (int i = 0; i < rowIndex+1; i++) {
            nums[i] = 1;
            for (int j = i-1; j > 0; j--) nums[j] += nums[j-1];
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rowIndex+1; i++) res.add(nums[i]);
        return res;
    }
}
