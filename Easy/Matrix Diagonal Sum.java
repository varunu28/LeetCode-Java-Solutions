class Solution {
  public int diagonalSum(int[][] mat) {
    int n = mat.length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += mat[i][i] + mat[i][n - i - 1];
    }
    return sum - (n % 2 == 0 ? 0 : mat[n / 2][n / 2]);
  }
}
