class Solution {
    public String multiply(String num1, String num2) {
    int[] result = new int[num1.length() + num2.length() + 1];
    int idx = result.length - 1;
    for (int i = num1.length() - 1; i >= 0; i--) {
      int currIdx = idx;
      int carry = 0;
      for (int j = num2.length() - 1; j >= 0; j--) {
        int currValue =
            carry + Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(
                num2.charAt(j)) + result[currIdx];
        carry = currValue / 10;
        currValue = currValue % 10;
        result[currIdx--] = currValue;
      }
      while (carry > 0) {
        int currValue = carry + result[currIdx];
        carry = currValue / 10;
        currValue = currValue % 10;
        result[currIdx--] = currValue;
      }
      idx--;
    }
    StringBuilder sb = new StringBuilder();
    int resultIdx = 0;
    while (resultIdx < result.length && result[resultIdx] == 0) {
      resultIdx++;
    }
    while (resultIdx < result.length) {
      sb.append(result[resultIdx++]);
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
