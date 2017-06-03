public class Solution {
    // 16:54
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
	int res = 0;
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == '(') stack.push(-1);
	    else if (!stack.isEmpty()) {
	        int accumulate = 0;
		while (!stack.isEmpty() && stack.peek() > 1) {
		    accumulate += stack.pop();
		}
		if (!stack.isEmpty()) {
		    stack.pop();
		    stack.push(accumulate+2);
		} else res = Math.max(res, accumulate);
	    }
	}
	while (!stack.isEmpty()) {
	    int acc = 0;
	    while (!stack.isEmpty() && stack.peek() > 1) {
		acc += stack.pop();
	    }
	    res = Math.max(res, acc);
	    while (!stack.isEmpty() && stack.peek() == -1) {
		stack.pop();
	    }
	}
	return res;
    }
}
