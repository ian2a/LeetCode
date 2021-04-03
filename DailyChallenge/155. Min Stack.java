class MinStack {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack1.offerLast(val);
        if (stack2.isEmpty() || val < stack2.peekLast()) {
            stack2.offerLast(val);
        } else {
            stack2.offerLast(stack2.peekLast());
        }
    }
    
    public void pop() {
        stack1.pollLast();
        stack2.pollLast();
    }
    
    public int top() {
        return stack1.peekLast();
    }
    
    public int getMin() {
        return stack2.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
