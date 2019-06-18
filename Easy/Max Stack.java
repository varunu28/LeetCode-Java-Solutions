class MaxStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty()) {
            maxStack.push(x);
        }
        else {
            maxStack.push(Math.max(maxStack.peek(), x));
        }
    }
    
    public int pop() {
        int val = stack.pop();
        maxStack.pop();
        return val;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int maxOnTop = maxStack.peek();
        Stack<Integer> temp = new Stack<>();
        while (stack.peek() != maxOnTop) {
            temp.add(stack.pop());
            maxStack.pop();
        }
        
        stack.pop();
        maxStack.pop();
        
        while (!temp.isEmpty()) {
            int popped = temp.pop();
            stack.push(popped);
            if (maxStack.isEmpty()) {
                maxStack.push(popped);
            }
            else {
                maxStack.push(Math.max(popped, maxStack.peek()));
            }
        }
        
        return maxOnTop;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
