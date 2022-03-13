class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '[' || c == '{' || c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char popped = stack.pop();
        if ((c == ')' && popped == '(') || 
            (c == ']' && popped == '[') ||
            (c == '}' && popped == '{')) {
          continue;
        }
        return false;
      }
    }
    return stack.isEmpty();
  }
}
