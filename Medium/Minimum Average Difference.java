class Solution {
  public int minimumAverageDifference(int[] nums) {
    int n = nums.length;
    long[] prefixSumArray = new long[n];
    long currSum = 0;
    for (int i = 0; i < n; i++) {
      currSum += nums[i];
      prefixSumArray[i] = currSum;
    }
    long minDifference = Integer.MAX_VALUE;
    int minDifferenceIdx = -1;
    for (int i = 0; i < n; i++) {
      long leftAverage = prefixSumArray[i] / (i + 1);
      long rightAverage = (i == n - 1) ? 0 : (prefixSumArray[n - 1] - prefixSumArray[i]) / (n - 1 - i);
      long absoluteDiff = Math.abs(leftAverage - rightAverage);
      if (minDifference > absoluteDiff) {
        minDifference = absoluteDiff;
        minDifferenceIdx = i;
      }
    }
    return minDifferenceIdx;
  }
}
