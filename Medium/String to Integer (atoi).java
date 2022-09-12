class Solution {
  public int myAtoi(String s) {
    int idx = 0;
    int n = s.length();
    while (idx < n && s.charAt(idx) == ' ') {
      idx++;
    }
    int sign = 1;
    if (idx < n && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
      sign = s.charAt(idx) == '-' ? -1 : 1;
      idx++;
    }
    if (idx == n || !Character.isDigit(s.charAt(idx))) {
      return 0;
    }
    while (idx < n && s.charAt(idx) == '0') {
      idx++;
    }
    int number = 0;
    while (idx < n && Character.isDigit(s.charAt(idx))) {
      int digit = Character.getNumericValue(s.charAt(idx));
      if ((number > Integer.MAX_VALUE / 10) || (number == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      number = number * 10 + digit;
      idx++;
    }
    return number * sign;
  }
}
