class Solution {
  public int calPoints(String[] ops) {
    Stack<Integer> stack = new Stack<>();
    int totalScore = 0;
    for (String op : ops) {
      if (op.equals("D")) {
        int newScore = 2 * stack.peek();
        totalScore += newScore;
        stack.push(newScore);
      } else if (op.equals("C")) {
        totalScore -= stack.pop();
      } else if (op.equals("+")) {
        int scoreTwo = stack.pop();
        int newScore = scoreTwo + stack.peek();
        stack.push(scoreTwo);
        stack.push(newScore);
        totalScore += newScore;
      } else {
        stack.push(Integer.parseInt(op));
        totalScore += Integer.parseInt(op);
      }
    }
    return totalScore;
  }
}
