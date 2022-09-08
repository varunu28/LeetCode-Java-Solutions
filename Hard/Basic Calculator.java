class Solution {
  public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    int number = 0;
    int sign = 1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        number = number * 10 + Character.getNumericValue(c);
      } else if (c == '+' || c == '-') {
        result += sign * number;
        sign = c == '+' ? 1 : -1;
        number = 0;
      } else if (c == '(') {
        stack.push(result);
        stack.push(sign);
        sign = 1;
        result = 0;
      } else if (c == ')') {
        result += sign * number;
        result *= stack.pop();
        result += stack.pop();
        number = 0;
      }
    }
    return result + (sign * number);
  }
}
