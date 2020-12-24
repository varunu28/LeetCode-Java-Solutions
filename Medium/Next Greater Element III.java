class Solution {
  public int nextGreaterElement(int n) {
    char[] digits = String.valueOf(n).toCharArray();
    int idx = digits.length - 2;
    while (idx >= 0) {
      if (Character.getNumericValue(digits[idx]) < Character.getNumericValue(digits[idx + 1])) {
        int secondIdx = digits.length - 1;
        while (secondIdx >= idx && digits[secondIdx] <= digits[idx]) {
          secondIdx--;
        } 
        swap(digits, idx, secondIdx);
        int start = idx + 1;
        int end = digits.length - 1;
        while (start < end) {
          swap(digits, start++, end--);
        }
        try {
          return Integer.parseInt(new String(digits));
        } catch (Exception e) {
          return -1;
        }
      }
      idx--;
    }
    return -1;
  }
  
  private void swap(char[] digits, int idxOne, int idxTwo) {
    char temp = digits[idxOne];
    digits[idxOne] = digits[idxTwo];
    digits[idxTwo] = temp;
  }
}
