class Solution {
  public int maxKilledEnemies(char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    int rows = grid.length;
    int cols = grid[0].length;
    int maxCount = 0;
    int rowHits = 0;
    int[] colHits = new int[cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (j == 0 || grid[i][j - 1] == 'W') {
          rowHits = 0;
          for (int k = j; k < cols; k++) {
            if (grid[i][k] == 'W') {
              break;
            }
            if (grid[i][k] == 'E') {
              rowHits++;
            }
          }
        }
        if (i == 0 || grid[i - 1][j] == 'W') {
          colHits[j] = 0;
          for (int k = i; k < rows; k++) {
            if (grid[k][j] == 'W') {
              break;
            }
            if (grid[k][j] == 'E') {
              colHits[j]++;
            }
          }
        }
        if (grid[i][j] == '0') {
          maxCount = Math.max(maxCount, rowHits + colHits[j]);
        }
      }
    }
    return maxCount;
  }
}
