class NumMatrix {

  int rows;
  int cols;
  int[][] rowLevelSum;
  public NumMatrix(int[][] matrix) {
    this.rows = matrix.length;
    this.cols = matrix[0].length;
    this.rowLevelSum = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      int sum = 0;
      for (int j = 0; j < cols; j++) {
        sum += matrix[i][j];
        this.rowLevelSum[i][j] = sum;
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int i = row1; i <= row2; i++) {
      sum += rowLevelSum[i][col2];
      if (col1 > 0) {
        sum -= rowLevelSum[i][col1 - 1];
      }
    }
    return sum;
  }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
