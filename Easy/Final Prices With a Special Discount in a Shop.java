class Solution {
  public int[] finalPrices(int[] prices) {
    Stack<Integer> stack = new Stack<>();
    int[] finalPrice = new int[prices.length];
    for (int i = prices.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
        stack.pop();
      }
      finalPrice[i] = prices[i] - (stack.isEmpty() ? 0 : prices[stack.peek()]);
      stack.push(i);
    }
    return finalPrice;
  }
}
