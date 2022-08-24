class Solution {
  public int findMiddleIndex(int[] nums) {
    int n = nums.length;
    int[] rightSum = new int[n];
    int currSum = 0;
    for (int i = n - 1; i >= 0; i--) {
      currSum += nums[i];
      rightSum[i] = currSum;
    }
    currSum = 0;
    for (int i = 0; i < n; i++) {
      int rightCurrSum = i != n - 1 ? rightSum[i + 1] : 0;
      if (currSum == rightCurrSum) {
        return i;
      }
      currSum += nums[i];
    }
    return -1;
  }
}
