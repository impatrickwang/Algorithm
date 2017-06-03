public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') stack.push(s.charAt(i));
	    else {
		if (stack.isEmpty()) return false;
		char c = stack.pop();
		if (s.charAt(i) == ')' && c != '(' || s.charAt(i) == '}' && c != '{' || s.charAt(i) == ']' && c != '[') return false;
	    }
	}
	return stack.isEmpty();
    }
}
