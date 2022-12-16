class MyQueue {
    
    private final Stack<Integer> stackOne;
    private final Stack<Integer> stackTwo;

    public MyQueue() {
        this.stackOne = new Stack<>();
        this.stackTwo = new Stack<>();
    }
    
    public void push(int x) {
        this.stackOne.push(x);
    }
    
    public int pop() {
        exchangeElements(stackOne, stackTwo);
        int popped = stackTwo.pop();
        exchangeElements(stackTwo, stackOne);
        return popped;
    }
    
    public int peek() {
        exchangeElements(stackOne, stackTwo);
        int peeked = stackTwo.peek();
        exchangeElements(stackTwo, stackOne);
        return peeked;
    }
    
    public boolean empty() {
        return stackOne.isEmpty();
    }
    
    private void exchangeElements(Stack<Integer> stack1, Stack<Integer> stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
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
