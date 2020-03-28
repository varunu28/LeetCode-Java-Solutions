class Solution {
  int[] memo;
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    memo = new int[n + 1];
    memo[1] = 1;
    memo[2] = 2;
    return helper(n);
  }
  
  private int helper(int n) {
    if (memo[n] != 0) {
      return memo[n];
    }
    memo[n] = helper(n - 1) + helper(n - 2);
    return memo[n];
  }
}
