class Solution {
  public int myAtoi(String s) {
    int idx = 0;
    int n = s.length();
    while (idx < n && s.charAt(idx) == ' ') {
      idx++;
    }
    int sign = 1;
    if (idx < n && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
      sign = s.charAt(idx++) == '-' ? -1 : 1;
    }
    long num = 0;
    while (idx < n && Character.isDigit(s.charAt(idx))) {
      num = num * 10 + Character.getNumericValue(s.charAt(idx++));
      if (sign == 1 && num > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      } else if (sign == -1 && num * sign < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
    }
    return (int) (num * sign);
  }
}
