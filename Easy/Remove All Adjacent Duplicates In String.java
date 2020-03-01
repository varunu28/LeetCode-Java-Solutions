class Solution {
  public String removeDuplicates(String S) {
    Stack<Integer> stack = new Stack<>();
    char[] chars = S.toCharArray();
    for (int i = 0; i < S.length(); i++) {
      if (stack.isEmpty() || chars[stack.peek()] != chars[i]) {
        stack.push(i);
      }
      else {
        chars[i] = '-';
        chars[stack.pop()] = '-';
      }
    }
    StringBuilder sb = new StringBuilder();
    for (char c : chars) {
      if (c != '-') {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
