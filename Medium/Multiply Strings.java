class Solution {
  public String multiply(String num1, String num2) {
    int m = num1.length();
    int n = num2.length();
    int[] ans = new int[m + n];
    int idx = ans.length - 1;
    for (int i = num1.length() - 1; i >= 0; i--) {
      int currIdx = idx;
      int carry = 0;
      for (int j = num2.length() - 1; j >= 0; j--) {
        int temp = (
          ans[currIdx] + Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j)) + carry
        );
        carry = temp > 9 ? temp / 10 : 0;
        temp = temp > 9 ? temp % 10 : temp;
        ans[currIdx--] = temp;
      }
      while (carry > 0) {
        int temp = ans[currIdx] + carry;
        carry = temp > 9 ? temp / 10 : 0;
        temp = temp > 9 ? temp % 10 : temp;
        ans[currIdx--] = temp;
      }
      idx--;
    }
    int zeroIdx = 0;
    while (zeroIdx < ans.length && ans[zeroIdx] == 0) {
      zeroIdx++;
    }
    StringBuilder sb = new StringBuilder();
    while (zeroIdx < ans.length) {
      sb.append(ans[zeroIdx++]);
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
