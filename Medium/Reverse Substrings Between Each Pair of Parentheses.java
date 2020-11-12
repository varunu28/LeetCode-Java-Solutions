class Solution {
  public String reverseParentheses(String s) {
    Stack<Integer> opened = new Stack<>();
    int n = s.length();
    int[] pair = new int[n];
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') {
        opened.push(i);
      } else if (s.charAt(i) == ')') {
        int startIdx = opened.pop();
        pair[i] = startIdx;
        pair[startIdx] = i;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0, jump = 1; i < n; i += jump) {
      if (s.charAt(i) == '(' || s.charAt(i) == ')') {
        i = pair[i];
        jump = -jump;
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }
}
