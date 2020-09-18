class Solution {
  public String addBinary(String a, String b) {
    int carry = 0;
    StringBuilder sb = new StringBuilder();
    int idxA = a.length() - 1;
    int idxB = b.length() - 1;
    while (idxA >= 0 || idxB >= 0 || carry > 0) {
      int temp = (
        (idxA >= 0 ? Character.getNumericValue(a.charAt(idxA--)) : 0) + 
        (idxB >= 0 ? Character.getNumericValue(b.charAt(idxB--)) : 0) + 
        carry
      );
      carry = temp > 1 ? 1 : 0;
      temp = temp > 1 ? (temp == 2 ? 0 : 1) : temp;
      sb.append(temp);
    }
    return sb.reverse().toString();
  }
}
