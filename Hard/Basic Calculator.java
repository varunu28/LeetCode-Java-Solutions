class Solution {
  public static  int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int res = 0;
    int num = 0;
    int sign = 1;
    boolean hasNumberStarted = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        hasNumberStarted = true;
        num = num * 10 + (int) (c - '0');
      } else if (c == '+' && hasNumberStarted) {
        hasNumberStarted = false;
        res += sign * num;
        num = 0;
        sign = 1;
      } else if (c == '-') {
        if(!hasNumberStarted) {
          sign *= -1;
          continue;
        }
        hasNumberStarted = false;
        res += sign * num;
        num = 0;
        sign = -1;
      } else if (c == '(') {
        stack.push(res);
        stack.push(sign);
        sign = 1;
        res = 0;
      } else if (c == ')') {
        res += sign * num;
        num = 0;
        res *= stack.pop(); // For sign
        res += stack.pop(); // Adding the num in stack
      }
    }
    return res + (num != 0 ? sign * num : 0);
  }
}
