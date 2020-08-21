class Solution {
  public int tribonacci(int n) {
    int[] dp = new int[Math.max(n + 1, 3)];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    return helper(n, dp);
  }
  
  private int helper(int n, int[] dp) {
    if (n == 0 || dp[n] != 0) {
      return dp[n];
    }
    dp[n] = helper(n - 1, dp) + helper(n - 2, dp) + helper(n - 3, dp);
    return dp[n];
  }
}
