class Solution {
  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stack.add(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char popped = stack.removeLast();
        if (!((c == ')' && popped == '(') || (c == ']' && popped == '[') || (c == '}' && popped == '{'))) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
