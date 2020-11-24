class Solution {
  public int calculate(String s) {
    int num = 0;
    char sign = '+';
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        num = num * 10 + Character.getNumericValue(c);
      } 
      if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
        if (sign == '+') {
          stack.push(num);
        } else if (sign == '-') {
          stack.push(-num);
        } else if (sign == '*') {
          stack.push(stack.pop() * num);
        } else {
          stack.push(stack.pop() / num);
        }
        sign = c;
        num = 0;
      }
    }
    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }
}
