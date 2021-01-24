class Solution {
  public String maximumTime(String time) {
    char[] digits = time.toCharArray();
    if (digits[0] == '?' || digits[1] == '?') {
      if (digits[0] == '?') {
        if (digits[1] == '?' || Character.getNumericValue(digits[1]) <= 3) {
          digits[0] = '2';
        } else {
          digits[0] = '1';
        }
      }
      if (digits[1] == '?') {
        if (Character.getNumericValue(digits[0]) <= 1) {
          digits[1] = '9';
        } else {
          digits[1] = '3';
        }
      }
    }
    if (digits[3] == '?' || digits[4] == '?') {
      if (digits[3] == '?') {
        digits[3] = '5';
      }
      if (digits[4] == '?') {
        digits[4] = '9';
      }
    }
    return String.valueOf(digits);
  }
}
