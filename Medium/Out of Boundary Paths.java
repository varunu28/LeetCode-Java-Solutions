class Solution {
  private final int MODULUS = 1000000000 + 7;
  
  public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    int dp[][] = new int[m][n];
    dp[startRow][startColumn] = 1;
    int count = 0;
    for (int currMove = 1; currMove <= maxMove; currMove++) {
      int[][] temp = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == m - 1) {
            count = (count + dp[i][j]) % MODULUS;
          }
          if (j == n - 1) {
            count = (count + dp[i][j]) % MODULUS;
          }
          if (i == 0) {
            count = (count + dp[i][j]) % MODULUS;
          }
          if (j == 0) {
            count = (count + dp[i][j]) % MODULUS;
          }
          temp[i][j] = (
              ((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % MODULUS +
              ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % MODULUS
          ) % MODULUS;
        }
      }
      dp = temp;
    }
    return count;
  }
}
