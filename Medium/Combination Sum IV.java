class Solution {
  public int combinationSum4(int[] nums, int target) {
    Integer[] dp = new Integer[target + 1];
    return getCount(target, nums, dp);
  }
  
  public int getCount(int target, int[] nums, Integer[] dp) {
    if (dp[target] != null) {
      return dp[target];
    }
    if (target == 0) {
      return 1;
    }
    if (target < 0) {
      return 0;
    }
    int total = 0;
    for (int num : nums) {
      if (target >= num) {
        total += getCount(target - num, nums, dp);
      }
    }
    return dp[target] = total;
  }
}
