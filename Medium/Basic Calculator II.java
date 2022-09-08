class Solution {
  public int calculate(String s) {
    int currNum = 0;
    int prevNum = 0;
    int result = 0;
    char operation = '+';
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        currNum = currNum * 10 + Character.getNumericValue(c);
      } 
      if ((!Character.isDigit(c) && !Character.isWhitespace(c)) || i == s.length() - 1) {
        if (operation == '-' || operation == '+') {
          result += prevNum;
          prevNum = operation == '+' ? currNum : -currNum;
        } else if (operation == '*') {
          prevNum = prevNum * currNum;
        } else {
          prevNum = prevNum / currNum;
        }
        operation = c;
        currNum = 0;
      }
    }
    result += prevNum;
    return result;
  }
}
