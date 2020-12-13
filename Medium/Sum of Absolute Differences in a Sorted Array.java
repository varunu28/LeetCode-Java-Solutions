class Solution {
  public int[] getSumAbsoluteDifferences(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];
    int[] leftToRightSum = new int[n];
    int[] rightToLeftSum = new int[n];
    int currSum = 0;
    for (int i = 0; i < n; i++) {
      currSum += nums[i];
      leftToRightSum[i] = currSum;
    }
    currSum = 0;
    for (int i = n - 1; i >= 0; i--) {
      currSum += nums[i];
      rightToLeftSum[i] = currSum;
    }
    for (int i = 0; i < n; i++) {
      answer[i] = (i == 0 ? 0 : i * nums[i] - leftToRightSum[i - 1]) + (i == n - 1 ? 0 : (rightToLeftSum[i + 1] - (n - 1 - i) * nums[i]));
    }
    return answer;
  }
}
