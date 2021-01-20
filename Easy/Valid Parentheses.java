class Solution {
  public boolean isValid(String s) {
    String starting = "({[";
    String ending = ")}]";
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (starting.indexOf(c) != -1) {
        stack.push(c);
      } else {
        if (stack.isEmpty() || starting.indexOf(stack.pop()) != ending.indexOf(c)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
