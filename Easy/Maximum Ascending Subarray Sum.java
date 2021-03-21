class Solution {
  public int maxAscendingSum(int[] nums) {
    int maximumSum = 0;
    int idx = 0;
    while (idx < nums.length) {
      int currSum = nums[idx++];
      while (idx < nums.length && nums[idx] > nums[idx - 1]) {
        currSum += nums[idx++];
      }
      maximumSum = Math.max(maximumSum, currSum);
    }
    return maximumSum;
  }
}
