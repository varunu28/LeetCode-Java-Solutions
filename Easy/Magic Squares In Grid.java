class Solution {
  public int numMagicSquaresInside(int[][] grid) {
    int rows = grid.length; 
    int cols = grid[0].length;
    int count = 0;
    for (int i = 0; i < rows - 2; i++) {
      for (int j = 0; j < cols - 2; j++) {
        if (grid[i + 1][j + 1] != 5) {
          continue;
        }
        if (
          magic(
            grid[i][j], grid[i][j + 1], grid[i][j + 2],
            grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2],
            grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2]
          )
        ) {
          count++;
        }
      }
    }
    return count;
  }
  
  private boolean magic(int... vals) {
    int[] count = new int[16];
    for (int v : vals) {
      count[v]++;
    }
    for (int v = 1; v <= 9; v++) {
      if (count[v] != 1) {
        return false;
      }
    }
    return (
      vals[0] + vals[1] + vals[2] == 15 &&
      vals[3] + vals[4] + vals[5] == 15 &&
      vals[6] + vals[7] + vals[8] == 15 &&
      vals[0] + vals[3] + vals[6] == 15 &&
      vals[1] + vals[4] + vals[7] == 15 &&
      vals[2] + vals[5] + vals[8] == 15 &&
      vals[0] + vals[4] + vals[8] == 15 &&
      vals[2] + vals[4] + vals[6] == 15
    );
  }
}
