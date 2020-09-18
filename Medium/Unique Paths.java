class Solution {
  Integer[][] dp;
  public int uniquePaths(int m, int n) {
    dp = new Integer[m][n];
    return dfs(m, n, 0, 0);
  }
  
  private int dfs(int m, int n, int x, int y) {
    if (x >= m || y >= n) {
      return 0;
    }
    if (dp[x][y] != null) {
      return dp[x][y];
    }
    if (x == m - 1 && y == n - 1) {
      return 1;
    }
    dp[x][y] = dfs(m, n, x + 1, y) + dfs(m, n, x, y + 1);
    return dp[x][y];
  }
}
