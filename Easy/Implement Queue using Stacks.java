class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> oldStack = new Stack<>();
    Stack<Integer> newStack = new Stack<>();
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!newStack.isEmpty()) {
            oldStack.push(newStack.pop());
        }
        oldStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!oldStack.isEmpty()) {
            newStack.push(oldStack.pop());
        }
        return newStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        while (!oldStack.isEmpty()) {
            newStack.push(oldStack.pop());
        }
        return newStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return oldStack.isEmpty() && newStack.isEmpty();
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
