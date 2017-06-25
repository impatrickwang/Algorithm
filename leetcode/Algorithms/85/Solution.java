public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) return 0;
        int[] cur = new int[matrix[0].length+1];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') cur[j] = 0;
                else cur[j]++;
            }
            res = Math.max(res, maxRectangle(cur));
        }
        return res;
    }

    private int maxRectangle(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                int h = nums[stack.pop()];
                int l = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, h * (i - l - 1));
            }
            stack.push(i);
        }
        return res;
    }
}
