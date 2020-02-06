class MyQueue {

  /** Initialize your data structure here. */
  Stack<Integer> stack;
  Stack<Integer> revStack;
  public MyQueue() {
    stack = new Stack<>();
    revStack = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    stack.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    while (!stack.isEmpty()) {
      revStack.push(stack.pop());
    }
    int num = revStack.pop();
    while (!revStack.isEmpty()) {
      stack.push(revStack.pop());
    }
    return num;
  }

  /** Get the front element. */
  public int peek() {
    while (!stack.isEmpty()) {
      revStack.push(stack.pop());
    }
    int num = revStack.peek();
    while (!revStack.isEmpty()) {
      stack.push(revStack.pop());
    }
    return num;
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stack.isEmpty();
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
