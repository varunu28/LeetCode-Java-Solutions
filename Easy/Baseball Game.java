class Solution {
  public int calPoints(String[] ops) {
    Stack<Integer> stack = new Stack<>();
    int sum = 0;
    for (String op : ops) {
      if (op.equals("+")) {
        int prev = stack.pop();
        int prevToPrev = stack.peek();
        int newScore = prev + prevToPrev;
        sum += newScore;
        stack.push(prev);
        stack.push(newScore);
      }
      else if (op.equals("C")) {
        sum -= stack.pop();
      }
      else if (op.equals("D")) {
        sum += stack.peek() * 2;
        stack.push(stack.peek() * 2);
      }
      else {
        stack.push(Integer.parseInt(op));
        sum += stack.peek();
      }
    }
    return sum;
  }
}
