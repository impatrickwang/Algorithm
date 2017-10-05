class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            else if (s.charAt(i) == '+') stack.push(-1);
            else if (s.charAt(i) == '-') stack.push(-2);
            else if (s.charAt(i) == '(') stack.push(-3);
            else if (s.charAt(i) == ')') {
                int sum = 0;
                int num = 0;
                int op = 0;
                do {
                    num = stack.pop();
                    op = stack.pop();
                    if (op == -2) sum -= num;
                    else sum += num;
                } while (op != -3);
                stack.push(sum);
            } else {
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                }
                i--;
                stack.push(num);
            }
        }
        int res = 0;
        int num = stack.pop();
        int op = 0;
        while (!stack.isEmpty()) {
            op = stack.pop();
            res += (op == -1 ? num : -num);
            num = stack.pop();
        }
        res += num;
        return res;
    }
}
