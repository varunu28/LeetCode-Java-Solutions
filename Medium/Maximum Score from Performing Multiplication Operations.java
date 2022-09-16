class Solution {
  public int maximumScore(int[] nums, int[] multipliers) {
    Integer[][] dp = new Integer[1001][1001];
    return helper(0, multipliers, nums, 0, dp);
  }
  
  private int helper(int idx, int[] multipliers, int[] nums, int start, Integer[][] dp) {
    if (idx == multipliers.length) {
      return 0;
    }
    if (dp[idx][start] != null) {
      return dp[idx][start];
    }
    int end = nums.length - (idx - start) - 1;
    int startOperation = multipliers[idx] * nums[start] + helper(idx + 1, multipliers, nums, start + 1, dp); 
    int endOperation = multipliers[idx] * nums[end] + helper(idx + 1, multipliers, nums, start, dp); 
    return dp[idx][start] = Math.max(startOperation, endOperation);
  }
}
