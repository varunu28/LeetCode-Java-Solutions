class Solution {
  public int scoreOfParentheses(String S) {
    Stack<Integer> stack = new Stack<>();
    int currMultiplier = 0;
    for (char c : S.toCharArray()) {
      if (c == '(') {
        stack.push(currMultiplier);
        currMultiplier = 0;
      } else {
        currMultiplier = stack.pop() + Math.max(2 * currMultiplier, 1);
      }
    }
    return currMultiplier;
  }
}
