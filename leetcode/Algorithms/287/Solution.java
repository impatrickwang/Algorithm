class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1;
        int h = nums.length-1;
        while (l < h) {
            int m = (l+h)/2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++)
                if (nums[i] >= l && nums[i] <= m) cnt++;
            if (cnt > m-l+1) h = m;
            else l = m+1;
        }
        return l;
    }
}
