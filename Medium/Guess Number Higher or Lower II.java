class Solution {
  public int getMoneyAmount(int n) {
    int[][] dp = new int[n + 1][n + 1];
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= n -i + 1; j++) {
        int minres = Integer.MAX_VALUE;
        for (int k = j; k < j + i - 1; k++) {
          int res = k + Math.max(dp[j][k - 1], dp[k + 1][j + i - 1]);
          minres = Math.min(minres, res);
        }
        dp[j][j + i - 1] = minres;
      }
    }
    return dp[1][n];
  }
}
