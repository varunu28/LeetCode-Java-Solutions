class Solution {
  public int sumOddLengthSubarrays(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      int currSum = 0;
      for (int j = i; j < arr.length; j++) {
        currSum += arr[j];
        if ((j - i + 1) % 2 != 0) {
          sum += currSum;
        }
      }
    }
    return sum;
  }
}
