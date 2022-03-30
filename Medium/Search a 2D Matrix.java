class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int rowIdx = matrix.length - 1;
    int colIdx = matrix[0].length - 1;
    while (rowIdx >= 0 && colIdx >= 0) {
      if (matrix[rowIdx][colIdx] == target) {
        return true;
      }
      if (matrix[rowIdx][colIdx] > target) {
        colIdx--;
        if (colIdx < 0) {
          colIdx = matrix[0].length - 1;
          rowIdx--;
        }
      } else {
        rowIdx--;
      }
    }
    return false;
  }
}
