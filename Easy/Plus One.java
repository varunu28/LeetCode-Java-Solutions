class Solution {
  public int[] plusOne(int[] digits) {
    int carry = 1;
    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
      int temp = digits[i] + carry;
      if (temp <= 9) {
        digits[i] = temp;
        return digits;
      }
      digits[i] = temp % 10;
    }
    int[] newDigits = new int[n + 1];
    newDigits[0] = 1;
    for (int i = 1; i < n + 1; i++) {
      newDigits[i] = digits[i - 1];
    }
    return newDigits;
  }   
}
