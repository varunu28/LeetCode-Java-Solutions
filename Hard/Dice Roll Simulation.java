class Solution {
  private final long MOD = (long) Math.pow(10, 9) + 7;
  
  public int dieSimulator(int n, int[] rollMax) {
    long[][] dp = new long[n][7];
    for(int i = 0; i < 6; i++) {
      dp[0][i] = 1;
    }
    dp[0][6] = 6;
    for(int i = 1; i < n; i++) {
      long sum = 0;
      for(int j = 0; j < 6; j++) {
        dp[i][j] = dp[i - 1][6];
        if (i - rollMax[j] < 0) {
          sum = (sum + dp[i][j]) % MOD;
        } else {
          if (i - rollMax[j] - 1 >= 0) { 
            dp[i][j] = (dp[i][j] - (dp[i - rollMax[j] - 1][6] - dp[i - rollMax[j] - 1][j])) % MOD + MOD;
          } else {
            dp[i][j] = (dp[i][j] - 1) % MOD;
          }
          sum = (sum + dp[i][j]) % MOD;
        }
      }
      dp[i][6] = sum;
    }
    return (int) (dp[n - 1][6]);
  }
}
