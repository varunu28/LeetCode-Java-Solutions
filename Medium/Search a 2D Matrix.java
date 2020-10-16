class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int rowIdx = matrix.length - 1;
    int colIdx = matrix[0].length - 1;
    while (rowIdx >= 0 && colIdx >= 0) {
      int val = matrix[rowIdx][colIdx];
      if (val == target) {
        return true;
      }
      if (val >= matrix[rowIdx][0]) {
        colIdx--;
        if (colIdx < 0) {
          colIdx = matrix[0].length - 1;
          rowIdx--;
        }
      }
      else {
        rowIdx--;
      }
    }
    return false;
  }
}
