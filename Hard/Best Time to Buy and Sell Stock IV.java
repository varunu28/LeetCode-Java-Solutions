class Solution {
  public int maxProfit(int k, int[] prices) {
    if (k == 0) {
      return 0;
    }
    int[][] dp = new int[k + 1][2];
    for (int i = 0; i <= k; i++) {
      dp[i][0] = 1000;
    }
    for (int i = 0; i < prices.length; i++) {
      for (int j = 1; j <= k; j++) {
        dp[j][0] = Math.min(dp[j][0], prices[i] - dp[j - 1][1]);
        dp[j][1] = Math.max(dp[j][1], prices[i] - dp[j][0]);
      }
    }
    return dp[k][1];
  }
}
