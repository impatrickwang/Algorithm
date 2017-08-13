public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i]))
                stack.push(stack.pop()+stack.pop());
            else if ("-".equals(tokens[i]))
                stack.push(-stack.pop()+stack.pop());
            else if ("*".equals(tokens[i]))
                stack.push(stack.pop()*stack.pop());
            else if ("/".equals(tokens[i])) {
                int d = stack.pop();
                stack.push(stack.pop()/d);
            } else stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }
}
