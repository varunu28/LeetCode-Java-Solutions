class Solution {
  public void setZeroes(int[][] matrix) {
    boolean firstRowZero = false;
    boolean firstColZero = false;
    int numRows = matrix.length;
    int numCols = matrix[0].length;
    // Mark if first column needs to be set zero
    for (int i = 0; i < numRows; i++) {
      if (matrix[i][0] == 0) {
        firstColZero = true;
      }
    }
    // Mark if first row needs to be set zero
    for (int i = 0; i < numCols; i++) {
      if (matrix[0][i] == 0) {
        firstRowZero = true;
      }
    }
    // If a value in matrix is zero set the value at first row and column to be zero
    for (int i = 1; i < numRows; i++) {
      for (int j = 1; j < numCols; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    // Update the complete column to be zero if first item of row is zero
    for (int i = 1; i < numRows; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < numCols; j++) {
          matrix[i][j] = 0;
        }
      }
    }
    // Update the complete row to be zero if first item of column is zero
    for (int i = 1; i < numCols; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 1; j < numRows; j++) {
          matrix[j][i] = 0;
        }
      } 
    }
    // Set the first row to zero if flag is set
    if (firstRowZero) {
      for (int i = 0; i < numCols; i++) {
        matrix[0][i] = 0;
      }
    }
    // Set the first column to zero if flag is set
    if (firstColZero) {
      for (int i = 0; i < numRows; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}
