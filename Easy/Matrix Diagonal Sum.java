class Solution {
  public int diagonalSum(int[][] mat) {
    int sum = 0;
    // Left -> Right Diagonal
    for (int i = 0; i < mat.length; i++) {
      sum += mat[i][i];
    }
    // Right -> Left Diagonal
    int rowIdx = 0;
    int colIdx = mat[0].length - 1;
    while (rowIdx < mat.length) {
      // Check to remove intersecting element in both diagonals
      if (rowIdx != colIdx) {
        sum += mat[rowIdx][colIdx];
      }
      rowIdx++;
      colIdx--;
    }
    return sum;
  }
}
