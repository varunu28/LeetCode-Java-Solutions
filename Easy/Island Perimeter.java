class Solution {
  int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  public int islandPerimeter(int[][] grid) {
    int sum = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          for (int[] dir : dirs) {
            sum += isBoundary(grid, i + dir[0], j + dir[1]) ? 1 : 0;
          }
        }
      }
    }
    return sum;
  }
  
  private boolean isBoundary(int[][] grid, int x, int y) {
    return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0;
  }
}
