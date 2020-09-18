class Solution {
  public String reverseWords(String s) {
    Stack<String> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    int n = s.length();
    while (idx < n) {
      if (s.charAt(idx) != ' ') {
        sb.append(s.charAt(idx));
      }
      if (s.charAt(idx) == ' ' || idx == n - 1) {
        if (sb.length() > 0) {
          stack.push(sb.toString());
          sb.setLength(0);
        }
      }
      idx++;
    }
    sb.setLength(0);
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
      if (!stack.isEmpty()) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }
}
