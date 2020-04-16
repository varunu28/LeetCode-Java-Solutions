class Solution {
  public String stringShift(String s, int[][] shifts) {
    int leftShiftAmount = 0;
    int rightShiftAmount = 0;
    for (int[] shift : shifts) {
      if (shift[0] == 0) {
        leftShiftAmount += shift[1];
      }
      else {
        rightShiftAmount += shift[1];
      }
    }
    if (leftShiftAmount > rightShiftAmount) {
      return shiftLeft(s, leftShiftAmount - rightShiftAmount);
    }
    else if (rightShiftAmount > leftShiftAmount) {
      return shiftRight(s, rightShiftAmount - leftShiftAmount);
    }
    else {
      return s;
    }
  }
  
  private String shiftLeft(String s, int n) {
    StringBuilder sb = new StringBuilder();
    n %= s.length();
    for (int i = n; i < s.length(); i++) {
      sb.append(s.charAt(i));
    }
    for (int i = 0; i < n; i++) {
      sb.append(s.charAt(i));
    }
    return sb.toString();
  }
  
  private String shiftRight(String s, int n) {
    StringBuilder sb = new StringBuilder();
    n %= s.length();
    int len = s.length();
    for (int i = 0; i < len - n; i++) {
      sb.append(s.charAt(i));
    }
    for (int i = s.length() - 1; i >= len - n; i--) {
      sb.insert(0, s.charAt(i));
    }
    return sb.toString();
  }
}
