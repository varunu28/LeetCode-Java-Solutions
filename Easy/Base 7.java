class Solution {
  public String convertToBase7(int num) {
    StringBuilder sb = new StringBuilder();
    char sign = num < 0 ? '-' : ' ';
    num = Math.abs(num);
    while (num > 0) {
      sb.append(num % 7);
      num /= 7;
    }
    String representation = sb.length() == 0 ? "0" : sb.reverse().toString();
    if (sign == '-') {
      return sign + representation;
    }
    return representation;
  }
}
