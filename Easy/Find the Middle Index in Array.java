class Solution {
  public int findMiddleIndex(int[] nums) {
    int[] leftSum = new int[nums.length];
    int[] rightSum = new int[nums.length];
    int currSum = 0;
    for (int i = 0; i < nums.length; i++) {
      leftSum[i] = currSum;
      currSum += nums[i];
    }
    currSum = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      rightSum[i] = currSum;
      currSum += nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      if (leftSum[i] == rightSum[i]) {
        return i;
      }
    }
    return -1;
  }
}
