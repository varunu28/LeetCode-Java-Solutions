class Solution {
  public int removeOnes(int[][] grid) {
    return removeOnesHelper(grid, 0, 0);
  }
  
  private int removeOnesHelper(int[][] grid, int x, int y) {
    int rows = grid.length;
    int cols = grid[0].length;
    int result = Integer.MAX_VALUE;
    int ones = 0; 
    for (int i = 0; i < rows; i++) {
      if ((x & (1 << i)) == 0) {
        for (int j = 0; j < cols; j++) {
          if ((y & (1 << j)) == 0 && grid[i][j] == 1) {
            ones++;
            result = Math.min(result, 1 + removeOnesHelper(grid, x + (1 << i), y + (1 << j)));
          }
        }
      }
    }
    return ones == 0 ? 0 : result;
  }
}
