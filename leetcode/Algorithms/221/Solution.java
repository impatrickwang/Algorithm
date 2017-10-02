class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) return 0;
        int[] heights = new int[matrix[0].length+1];
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length+1; j++) {
                heights[j] = (j < matrix[0].length && matrix[i][j] == '1') ? heights[j]+1 : 0;
                while (!stack.isEmpty() && heights[j] <= heights[stack.peek()]) {
                    int index = stack.pop();
                    int start = stack.isEmpty()?-1:stack.peek();
                    int length = Math.min(j-1-start, heights[index]);
                    res = Math.max(res, length*length);
                }
                stack.push(j);
            }
            stack.pop();
            assert(stack.isEmpty());
        }
        return res;
    }
}
