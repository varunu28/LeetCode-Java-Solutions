class CustomStack {
  
  private Stack<Integer> stack;
  private int[] incrementArray;
  private int maxSize;
  
  public CustomStack(int maxSize) {
    this.stack = new Stack<>();
    this.incrementArray = new int[maxSize];
    this.maxSize = maxSize;
  }

  public void push(int x) {
    if (this.stack.size() < this.maxSize) {
      this.stack.push(x);
    }
  }

  public int pop() {
    int idx = this.stack.size() - 1;
    if (idx < 0) {
      return -1;
    }
    if (idx > 0) {
      this.incrementArray[idx - 1] += this.incrementArray[idx];
    }
    int result = this.stack.pop() + this.incrementArray[idx];
    this.incrementArray[idx] = 0;
    return result;
  }

  public void increment(int k, int val) {
    int idx = Math.min(k, this.stack.size()) - 1;
    if (idx >= 0) {
      this.incrementArray[idx] += val;
    }
  }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
