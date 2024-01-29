class MyQueue {

    private final Stack<Integer> first;
    private final Stack<Integer> second;

    public MyQueue() {
        this.first = new Stack<>();
        this.second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        move(first, second);
        int result = second.pop();
        move(second, first);
        return result;
    }
    
    public int peek() {
        move(first, second);
        int result = second.peek();
        move(second, first);
        return result;
    }
    
    public boolean empty() {
        return first.isEmpty();
    }

    private void move(Stack<Integer> from, Stack<Integer> to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
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
