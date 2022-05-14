class MyStack {
  
  private Queue<Integer> primaryQueue;
  private Queue<Integer> secondaryQueue;
  
  public MyStack() {
    this.primaryQueue = new LinkedList<>();
    this.secondaryQueue = new LinkedList<>();
  }

  public void push(int x) {
    this.primaryQueue.add(x);
  }

  public int pop() {
    int result = moveFromPrimaryToSecondary();
    moveFromSecondaryToPrimary(true);
    return result;
  }

  public int top() {
    int result = moveFromPrimaryToSecondary();
    moveFromSecondaryToPrimary(false);
    return result;
  }
  
  public boolean empty() {
    return this.primaryQueue.isEmpty();
  }
  
  private int moveFromPrimaryToSecondary() {
    int last = this.primaryQueue.peek();
    while (!this.primaryQueue.isEmpty()) {
      last = this.primaryQueue.peek();
      this.secondaryQueue.add(this.primaryQueue.remove());
    }
    return last;
  }
  
  private void moveFromSecondaryToPrimary(boolean removeLast) {
    while (this.secondaryQueue.size() > 1) {
      this.primaryQueue.add(this.secondaryQueue.remove());
    }
    if (removeLast) {
      this.secondaryQueue.remove();
    } else {
      this.primaryQueue.add(this.secondaryQueue.remove());
    }
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
