class Solution {
  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int endIdxA = a.length() - 1;
    int endIdxB = b.length() - 1;
    int carry = 0;
    while (endIdxA >= 0 || endIdxB >= 0 || carry > 0) {
      int value = carry;
      if (endIdxA >= 0) {
        value += Character.getNumericValue(a.charAt(endIdxA--));
      }
      if (endIdxB >= 0) {
        value += Character.getNumericValue(b.charAt(endIdxB--));
      }
      sb.append(value % 2);
      carry = value / 2;
    }
    return sb.reverse().toString();
  }
}
