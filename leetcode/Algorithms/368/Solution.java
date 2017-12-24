class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] cnts = new int[nums.length];
        int[] last = new int[nums.length];
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            int p = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (p < 0 || cnts[j] > cnts[p]) p = j;
                }
            }
            last[i] = p;
            cnts[i] = p < 0 ? 1 : cnts[p]+1;
            if (max < 0 || cnts[i] > cnts[max]) max = i;
        }
        List<Integer> res = new LinkedList<>();
        while (max >= 0) {
            res.add(0, nums[max]);
            max = last[max];
        }
        return res;
    }
}
