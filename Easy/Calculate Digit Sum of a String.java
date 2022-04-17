class Solution {
  public String digitSum(String s, int k) {
    while (s.length() > k) {
      s = formDigitSum(s, k);
    }
    return s;
  }
  
  private String formDigitSum(String s, int k) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i += k) {
      int currSum = 0;
      for (int j = i; j < Math.min(i + k, s.length()); j++) {
        currSum += Character.getNumericValue(s.charAt(j));
      }
      sb.append(currSum);
    }
    return sb.toString();
  }
}
