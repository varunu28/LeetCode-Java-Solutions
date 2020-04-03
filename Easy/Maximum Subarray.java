class Solution {
  public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int currSum = nums[0];
    int maxSum = currSum;
    for (int i = 1; i < nums.length; i++) {
      currSum = Math.max(currSum + nums[i], nums[i]);
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }
}
