class Solution {
  public String removeOuterParentheses(String S) {
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (stack.isEmpty() && c == '(') {
        stack.push(c);
        continue;
      }
      if (stack.size() == 1 && c == ')') {
        stack.pop();
        continue;
      }
      if (c == '(') {
        stack.push(c);
      }
      else {
        stack.pop();
      }
      sb.append(c);
    }
    return sb.toString();
  }
}
