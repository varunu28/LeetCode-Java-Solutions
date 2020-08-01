class Solution {
  public double knightProbability(int N, int K, int r, int c) {
    double[][] dp = new double[N][N];
    int[] rowMoves = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
    int[] colMoves = new int[]{1, -1, 2, -2, 2, -2, 1, -1};
    dp[r][c] = 1;
    while (K-- >  0) {
      double[][] copy = new double[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          for (int k = 0; k < 8; k++) {
            int destR = i + rowMoves[k];
            int destC = j + colMoves[k];
            if (destR >= 0 && destR < N && destC >= 0 && destC < N) {
              copy[destR][destC] += dp[i][j] / 8.0;
            }
          }
        }
      }
      dp = copy;
    }
    double ans = 0.0;
    for (double[] row : dp) {
      for (double val : row) {
        ans += val;
      }
    }
    return ans;
  }
}
