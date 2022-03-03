class Solution {
  public int numberOfArithmeticSlices(int[] nums) {
    int[] dp = new int[nums.length];
    int count = 0;
    for (int i = 2; i < dp.length; i++) {
      if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
        dp[i] = dp[i - 1] + 1;
        count += dp[i];
      }
    }
    return count;
  }
}
