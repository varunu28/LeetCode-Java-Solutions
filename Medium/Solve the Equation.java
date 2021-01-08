class Solution {
  public String solveEquation(String equation) {
    int[] equationFirst = parseEquation(equation.split("=")[0]);
    int[] equationSecond = parseEquation(equation.split("=")[1]);
    int constantPart = equationSecond[1] - equationFirst[1];
    int variablePart = equationFirst[0] - equationSecond[0];
    if (variablePart == 0) {
      return constantPart == 0 ? "Infinite solutions" : "No solution";
    }
    int sign = (variablePart < 0 && constantPart < 0) || (variablePart > 0 && constantPart > 0) ? 1 : -1;
    if (Math.abs(constantPart) % Math.abs(variablePart) == 0) {
      constantPart = Math.abs(constantPart) / Math.abs(variablePart);
      variablePart = 1;
    } 
    return (variablePart > 1 ? variablePart : "") + "x=" + sign * constantPart;
  }
  
  private int[] parseEquation(String s) {
    int variablePart = 0;
    int constantPart = 0;
    int sign = 1;
    int n = s.length();
    for (int idx = 0; idx < n;) {
      if (s.charAt(idx) == 'x') {
        variablePart += sign;
        idx++;
        sign = 1;
      } else if (Character.isDigit(s.charAt(idx))) {
        int num = 0;
        while (idx < n && Character.isDigit(s.charAt(idx))) {
          num = num * 10 + Character.getNumericValue(s.charAt(idx++));
        }
        if (idx != n && s.charAt(idx) == 'x') {
          variablePart += sign * num;
          idx++;
        } else {
          constantPart += sign * num;
        }
        sign = 1;
      } else {
        sign = s.charAt(idx++) == '+' ? 1 : -1;
      }
    }
    return new int[]{variablePart, constantPart};
  }
}
