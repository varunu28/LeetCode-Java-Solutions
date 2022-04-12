class Solution {
  public int largestInteger(int num) {
    char[] digits = String.valueOf(num).toCharArray();
    int[] frequency = new int[10];
    for (int i = 0; i < digits.length; i++) {
      frequency[digits[i] - '0']++;
    }
    int largestNumber = 0;
    int evenIdx = 8;
    int oddIdx = 9;
    for (int i = 0; i < digits.length; i++) {
      if (digits[i] % 2 == 0) {
        while (frequency[evenIdx] == 0) {
          evenIdx -= 2;
        }
        frequency[evenIdx]--;
        largestNumber = largestNumber * 10 + evenIdx;
      } else {
        while (frequency[oddIdx] == 0) {
          oddIdx -= 2;
        }
        frequency[oddIdx]--;
        largestNumber = largestNumber * 10 + oddIdx;
      }
    }
    return largestNumber;
  }
}
