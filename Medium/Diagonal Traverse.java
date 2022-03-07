class Solution {
  public int[] findDiagonalOrder(int[][] matrix) {
    int dir = 0;
    int x = 0;
    int y = 0;
    int numOfRows = matrix.length;
    int numOfCols = matrix[0].length;
    int[] ans = new int[numOfRows * numOfCols];
    for (int i = 0; i < numOfRows * numOfCols; i++) {
      ans[i] = matrix[x][y];
      if ((x + y) % 2 == 0) {
        if (y == numOfCols - 1) {
          x++;
        } else if (x == 0) {
          y++;
        } else {
          x--;
          y++;
        }
      } else {
        if (x == numOfRows - 1) {
          y++;
        } else if (y == 0) {
          x++;
        } else {
          x++;
          y--;
        }
      }
    }
    return ans;
  }
}
