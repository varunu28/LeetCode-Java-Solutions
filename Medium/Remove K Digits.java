class Solution {
  public String removeKdigits(String num, int k) {
    LinkedList<Character> stack = new LinkedList<>();
    for (char c : num.toCharArray()) {
      while (!stack.isEmpty() && k > 0 && stack.peekLast() > c) {
        stack.removeLast();
        k--;
      } 
      stack.addLast(c);
    }
    while (k-- > 0) {
      stack.removeLast();
    }
    StringBuilder sb = new StringBuilder();
    boolean currZero = true;
    for (char c : stack) {
      if (currZero && c == '0') {
        continue;
      }
      currZero = false;
      sb.append(c);
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
