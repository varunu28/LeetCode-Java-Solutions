class MinStack {

    /** initialize your data structure here. */
  Stack<Integer> stack;
  Stack<Integer> min;
  public MinStack() {
    stack = new Stack<>();
    min = new Stack<>();
  }

  public void push(int x) {
    stack.push(x);
    min.push(Math.min(x, min.isEmpty() ? Integer.MAX_VALUE : min.peek()));
  }

  public void pop() {
    stack.pop();
    min.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min.peek();
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
