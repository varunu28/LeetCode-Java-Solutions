class Solution {
  public String parseTernary(String expression) {
    if (expression == null || expression.length() == 0) {
      return "";
    }
    Deque<Character> stack = new LinkedList<>();
    int n = expression.length();
    for (int i = n - 1; i >= 0; i--) {
      char c = expression.charAt(i);
      if (!stack.isEmpty() && stack.peek() == '?') {
        stack.pop();  // Pop ?
        char first = stack.pop();
        stack.pop();  // Pop :
        char second = stack.pop();
        stack.push(c == 'T' ? first : second);
      }
      else {
        stack.push(c);
      }
    }
    return String.valueOf(stack.peek());
  }
}
