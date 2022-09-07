class Solution {
  public String decodeString(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == ']') {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && stack.peek() != '[') {
          sb.append(stack.pop());
        }
        stack.pop();
        String temp = sb.toString();
        sb.setLength(0);
        while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
          sb.append(stack.pop());
        }
        int count = Integer.parseInt(sb.reverse().toString());
        while (count-- > 0) {
          for (int i = temp.length() - 1; i >= 0; i--) {
            stack.push(temp.charAt(i));
          }
        }
      } else {
        stack.push(c);
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }
}
