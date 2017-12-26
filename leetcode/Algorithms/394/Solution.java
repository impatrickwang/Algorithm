class Solution {
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                if (i-1 >= 0 && s.charAt(i-1) >= '0' && s.charAt(i-1) <= '9') {
                    int m = i-1;
                    while (s.charAt(m) >= '0' && s.charAt(m) <= '9') {
                        m--;
                    }
                    stack.push(s.substring(last, m+1));
                    stack.push(s.substring(m+1, i));
                } else stack.push("0");
                stack.push("[");
                last = i+1;
            } else if (s.charAt(i) == ']') {
                String sub = s.substring(last, i);
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    sub = stack.pop() + sub;
                }
                if (stack.isEmpty()) stack.push(sub);
                else {
                    stack.pop();
                    String num = stack.pop();
                    stack.push(repeat(sub, num));
                }
                last = i+1;
            }
        }
        if (last < s.length()) stack.push(s.substring(last));
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop()+res;
        }
        return res;
    }

    private String repeat(String sub, String num) {
        int cnt = 0;
        for (int i = 0; i < num.length(); i++) cnt = cnt*10 + num.charAt(i) - '0';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) sb.append(sub);
        return sb.toString();
    }
}
