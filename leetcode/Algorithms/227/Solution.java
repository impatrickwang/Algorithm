class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') stack.push(-1);
            else if (s.charAt(i) == '-') stack.push(-2);
            else if (s.charAt(i) == '*') stack.push(-3);
            else if (s.charAt(i) == '/') stack.push(-4);
            else if (s.charAt(i) == ' ') continue;
            else {
                int num = 0;
                while (i < s.length() && (s.charAt(i) == ' ' || s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                    if (s.charAt(i) == ' ') {
                        i++;
                        continue;
                    }
                    num = num*10 + s.charAt(i) - '0';
                    i++;
                }
                if (!stack.isEmpty() && stack.peek() < -2) {
                    int op = stack.pop();
                    int pnum = stack.pop();
                    if (op == -3) stack.push(pnum*num);
                    else stack.push(pnum/num);
                } else stack.push(num);
                i--;
            }
        }
        int res = stack.removeLast();
        while (!stack.isEmpty()) {
            int op = stack.removeLast();
            assert(op == -1 || op == -2);
            if (op == -1) res = res+stack.removeLast();
            else res = res-stack.removeLast();
        }
        return res;
    }
}
