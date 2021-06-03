class Solution {
  public int minPairSum(int[] nums) {
    Arrays.sort(nums);
    int start = 0;
    int end = nums.length - 1;
    int maxPairSum = -1;
    while (start < end) {
      int currSum = nums[start++] + nums[end--];
      maxPairSum = maxPairSum == -1 ? currSum : Math.max(maxPairSum, currSum);
    }
    return maxPairSum;
  }
}
