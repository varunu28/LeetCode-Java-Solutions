class Solution {
  public String multiply(String num1, String num2) {
    int m = num1.length();
    int n = num2.length();
    int[] result = new int[m + n];
    int endIdx = m + n - 1;
    for (int i = m - 1; i >= 0; i--) {
      int resultIdx = endIdx;
      int carry = 0;
      for (int j = n - 1; j >= 0; j--) {
        int currValue = result[resultIdx] + carry + Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
        carry = currValue / 10;
        result[resultIdx--] = currValue % 10;
      }
      while (carry > 0) {
        result[resultIdx--] = carry % 10;
        carry /= 10;
      }
      endIdx--;
    }
    int idx = 0;
    while (idx < result.length && result[idx] == 0) {
      idx++;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = idx; i < result.length; i++) {
      sb.append(result[i]);
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
