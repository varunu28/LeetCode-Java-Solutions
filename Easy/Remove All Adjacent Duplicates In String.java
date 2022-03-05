class Solution {
  public String removeDuplicates(String s) {
    Stack<Character> stack = new Stack<>();
    int idx = 0;
    while (idx < s.length()) {
      char c = s.charAt(idx);
      if (!stack.isEmpty() && stack.peek() == c) {
        stack.pop();
      } else {
        stack.push(c);
      }
      idx++;
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }
}
