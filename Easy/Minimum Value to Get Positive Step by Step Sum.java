class Solution {
  public int minStartValue(int[] nums) {
    int minPrefixSum = 0;
    int currSum = 0;
    for (int num : nums) {
      currSum += num;
      minPrefixSum = Math.min(minPrefixSum, currSum);
    }
    return -1 * minPrefixSum + 1;
  }
}
