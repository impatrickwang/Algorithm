public class MinStack {
    Deque<Integer> m;

    Deque<Integer> s;

    /** initialize your data structure here. */
    public MinStack() {
        m = new ArrayDeque<Integer>();
        s = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        s.push(x);
        if (m.isEmpty() || x < m.peek()) m.push(x);
        else m.push(m.peek());
    }
    
    public void pop() {
        m.pop();
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return m.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
