class Solution {
  public int uniquePaths(int m, int n) {
    Integer[][] dp = new Integer[m][n];
    return helper(0, 0, m, n, dp);
  }
  
  private int helper(int currX, int currY, int m, int n, Integer[][] dp) {
    if (currX == m - 1 && currY == n - 1) {
      return 1;
    }
    if (currX >= m || currY >= n) {
      return 0;
    }
    if (dp[currX][currY] != null) {
      return dp[currX][currY];
    }
    dp[currX][currY] = helper(currX + 1, currY, m, n, dp) + helper(currX, currY + 1, m, n, dp);
    return dp[currX][currY];
  }
}
