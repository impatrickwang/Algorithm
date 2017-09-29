// 21:54
class MyQueue {

    Deque<Integer> s;
    Deque<Integer> ss;

    /** Initialize your data structure here. */
    public MyQueue() {
        s = new ArrayDeque<Integer>();
        ss = new ArrayDeque<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (s.size() > 1) {
            ss.push(s.pop());
        }
        int res = s.pop();
        while (!ss.isEmpty()) {
            s.push(ss.pop());
        }
        return res;
    }
    
    /** Get the front element. */
    public int peek() {
        int res = 0;
        while (!s.isEmpty()) {
            res = s.pop();
            ss.push(res);
        }
        while (!ss.isEmpty()) {
            s.push(ss.pop());
        }
        return res;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
