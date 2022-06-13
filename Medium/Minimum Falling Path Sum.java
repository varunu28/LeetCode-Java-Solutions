class Solution {
  public int minFallingPathSum(int[][] matrix) {
    int minFallingSum = Integer.MAX_VALUE;
    Integer[][] dp = new Integer[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      minFallingSum = Math.min(minFallingSum, findMinFallingPathSumHelper(matrix, 0, i, dp));
    }
    return minFallingSum;
  }
  
  private int findMinFallingPathSumHelper(int[][] matrix, int row, int col, Integer[][] dp) {
    if (col < 0 || col == matrix.length) {
      return Integer.MAX_VALUE;
    }
    if (row == matrix.length - 1) {
      return matrix[row][col];
    }
    if (dp[row][col] != null) {
      return dp[row][col];
    }
    int leftSum = findMinFallingPathSumHelper(matrix, row + 1, col, dp);
    int middleSum = findMinFallingPathSumHelper(matrix, row + 1, col + 1, dp);
    int rightSum = findMinFallingPathSumHelper(matrix, row + 1, col - 1, dp);
    dp[row][col] = Math.min(leftSum, Math.min(middleSum, rightSum)) + matrix[row][col];
    return dp[row][col];
  }
}
