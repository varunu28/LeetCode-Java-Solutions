class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int rowIdx = rows - 1;
    int colIdx = 0;
    while (rowIdx >= 0 && colIdx < cols) {
      if (matrix[rowIdx][colIdx] > target) {
        rowIdx--;
      } else if (matrix[rowIdx][colIdx] < target) {
        colIdx++;
      } else {
        return true;
      }
    }
    return false;
  }
}
