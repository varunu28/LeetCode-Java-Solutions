class Solution {
  public int longestLine(int[][] M) {
    if (M.length == 0 || M[0].length == 0) {
      return 0;
    }
    int maxLength = 0;
    int rows = M.length;
    int cols = M[0].length;
    int[][] dirs = {{-1, 0}, {0, -1}, {-1, 1}, {-1, -1}};
    int[][][] dp = new int[rows][cols][4];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (M[i][j] == 1) {
          for (int k = 0; k < 4; k++) {
            dp[i][j][k] = 1;
            int prevI = i + dirs[k][0];
            int prevJ = j + dirs[k][1];
            if (isValid(prevI, prevJ, rows, cols)) {
              dp[i][j][k] += dp[prevI][prevJ][k];
            }
            maxLength = Math.max(maxLength, dp[i][j][k]);
          }
        }
      }
    }
    return maxLength;
  }

  private boolean isValid(int x, int y, int rows, int cols) {
    return x >= 0 && x < rows && y >= 0 && y < cols;
  }
}
