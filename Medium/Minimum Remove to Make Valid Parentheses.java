class Solution {
  public String minRemoveToMakeValid(String s) {
    Stack<Integer> stack = new Stack<>();
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '(') {
        stack.push(i);
      }
      else if (chars[i] == ')') {
        if (stack.isEmpty()) {
          chars[i] = '-';
        }
        else {
          stack.pop();
        }
      }
    }
    while (!stack.isEmpty()) {
      chars[stack.pop()] = '-';
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] != '-') {
        sb.append(chars[i]);
      }
    }
    return sb.toString();
  }
}
