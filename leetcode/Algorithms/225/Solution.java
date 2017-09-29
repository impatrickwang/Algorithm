class MyStack {

    Queue<Integer> q;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> p = new LinkedList<>();
        while (q.size() > 1) {
            p.add(q.remove());
        }
        int res = q.remove();
        q = p;
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        Queue<Integer> p = new LinkedList<>();
        int res = 0; 
        while (!q.isEmpty()) {
            res = q.remove();
            p.add(res);
        }
        q = p;
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();     
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
