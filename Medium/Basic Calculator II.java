class Solution {
  public int calculate(String s) {
    char sign = '+';
    int currNum = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        currNum = currNum * 10 + Character.getNumericValue(s.charAt(i));
      } 
      if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1) {
        updateStackForPreviousSign(sign, stack, currNum);
        currNum = 0;
        sign = s.charAt(i);
      }
    }
    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }

  private void updateStackForPreviousSign(char sign, Stack<Integer> stack, int currNum) {
    switch (sign) {
      case '+':
        stack.push(currNum);
        break;
      case '-':
        stack.push(-1 * currNum);
        break;
      case '/':
        stack.push(stack.pop() / currNum);
        break;
      case '*':
        stack.push(stack.pop() * currNum);
        break;
      default:
        break;
    }
  }
}
