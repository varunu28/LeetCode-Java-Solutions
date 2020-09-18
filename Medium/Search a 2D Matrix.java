class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int i = 0;
    int j = 0;
    int rows = matrix.length;
    int cols = matrix[0].length;
    while (i < rows && j < cols) {
      int num = matrix[i][j];
      if (num == target) {
        return true;
      }
      else {
        if (i != rows - 1 && matrix[i + 1][j] <= target) {
          i++;
        }
        else {
          j++;
        }
      }
    }
    return false;
  }
}
