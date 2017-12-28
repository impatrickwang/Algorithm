class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";
        Deque<Integer> stack = new ArrayDeque<>();
        int remain = k;
        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i)-'0';
            while (!stack.isEmpty() && remain > 0 && stack.peek() > cur) {
                stack.pop();
                remain--;
            }
            stack.push(cur);
        }
        while (remain > 0) {
            stack.pop();
            remain--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String res = sb.reverse().toString();
        int i = 0;
        while (i < res.length()-1 && res.charAt(i) == '0') {
            i++;
        }
        return res.substring(i);
    }
}
