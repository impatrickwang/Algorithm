class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null) return false;
        String[] splits = preorder.split(",");
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < splits.length; i++) {
            if ("#".equals(splits[i]) && "#".equals(stack.peek())) {
                do {
                    stack.pop();
                    if (stack.isEmpty() || stack.peek().equals("#")) return false;
                    stack.pop();
                } while (!stack.isEmpty() && stack.peek().equals("#"));
            }
            stack.push(splits[i]);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
