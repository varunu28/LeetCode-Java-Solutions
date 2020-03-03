class Solution {
  int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  public int getMaximumGold(int[][] grid) {
    int maxGold = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int currGold = getMaxGold(grid, i, j, rows, cols, new boolean[rows][cols]);
        maxGold = Math.max(maxGold, currGold);
      }
    }
    return maxGold;
  }
  
  private int getMaxGold(int[][] grid, int x, int y, int rows, int cols, boolean[][] visited) {
    if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || grid[x][y] == 0) {
      return 0;
    }
    int curr = 0;
    visited[x][y] = true;
    for (int[] dir : dirs) {
      int newX = x + dir[0];
      int newY = y + dir[1];
      curr = Math.max(curr, getMaxGold(grid, newX, newY, rows, cols, visited));
    }
    visited[x][y] = false;
    return grid[x][y] + curr;
  }
}
