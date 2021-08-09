class Solution {
  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int idxOne = num1.length() - 1;
    int idxTwo = num2.length() - 1;
    int carry = 0;
    while (idxOne >= 0 || idxTwo >= 0 || carry > 0) {
      int temp = carry;
      if (idxOne >= 0 && idxTwo >= 0) {
        temp += Character.getNumericValue(num1.charAt(idxOne--)) + Character.getNumericValue(num2.charAt(idxTwo--));
      } else if (idxOne >= 0 && idxTwo < 0) {
        temp += Character.getNumericValue(num1.charAt(idxOne--));
      } else if (idxOne < 0 && idxTwo >= 0) {
        temp += Character.getNumericValue(num2.charAt(idxTwo--));
      }
      carry = temp > 9 ? 1 : 0;
      temp = temp > 9 ? temp % 10 : temp;
      sb.append(temp);
    }
    return sb.reverse().toString();
  }
}
