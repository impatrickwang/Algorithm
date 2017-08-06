public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int h = numbers.length-1;
        int[] res = new int[2];
        while (l < h) {
            int sum = numbers[l]+numbers[h];
            if (sum == target) {
                res = new int[] {l+1, h+1};
                break;
            } else if (sum < target) l++;
            else h--;
        }
        return res;
    }
}
