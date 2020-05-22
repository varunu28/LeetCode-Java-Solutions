class StockSpanner {
  Stack<Integer> stack;
  Stack<Integer> occurences;
  public StockSpanner() {
    stack = new Stack<>();
    occurences = new Stack<>();
  }

  public int next(int price) {
    int count = 1;
    while (!stack.isEmpty() && stack.peek() <= price) {
      stack.pop();
      count += occurences.pop();
    }
    stack.push(price);
    occurences.push(count);
    return count;
  }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
