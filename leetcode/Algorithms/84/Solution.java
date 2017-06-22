public class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        heigths = Arrays.copyOf(heights, heights.length+1);
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int index = stack.pop();
                int l = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, heights[index] * (i-l-1));
            }
            stack.push(i);
        }
        return res;
    }
}
