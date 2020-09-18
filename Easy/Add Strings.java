class Solution {
  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int idx1 = num1.length() - 1;
    int idx2 = num2.length() - 1;
    int carry = 0;
    while (idx1 >= 0 || idx2 >= 0) {
      int temp = carry;
      if (idx1 >= 0 && idx2 >= 0) {
        temp += Character.getNumericValue(num1.charAt(idx1--)) + Character.getNumericValue(num2.charAt(idx2--));
      }
      else if (idx1 >= 0 && idx2 < 0) {
        temp += Character.getNumericValue(num1.charAt(idx1--));
      }
      else {
        temp += Character.getNumericValue(num2.charAt(idx2--));
      }
      carry = temp > 9 ? 1 : 0;
      temp = temp > 9 ? temp % 10 : temp;
      sb.append(temp);
    }
    if (carry > 0) {
      sb.append(carry);
    }
    return sb.reverse().toString();
  }
}
