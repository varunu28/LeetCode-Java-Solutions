class MaxStack {

  /** initialize your data structure here. */
  Stack<Integer> stack;
  Stack<Integer> max;
  public MaxStack() {
    stack = new Stack<>();
    max = new Stack<>();
  }

  public void push(int x) {
    stack.push(x);
    max.push(max.isEmpty() ? x : Math.max(x, max.peek()));
  }

  public int pop() {
    max.pop();
    return stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int peekMax() {
    return max.peek();
  }

  public int popMax() {
    int num = max.peek();
    Stack<Integer> temp = new Stack<>();
    while (stack.peek() != num) {
      temp.push(stack.pop());
      max.pop();
    }
    max.pop();
    stack.pop();
    while (!temp.isEmpty()) {
      push(temp.pop());
    }
    return num;
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
