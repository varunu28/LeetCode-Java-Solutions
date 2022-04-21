class Solution {
  
  private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  
  public int maxAreaOfIsland(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int maxArea = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] != 0) {
          grid[i][j] = 0;
          int currentArea = getArea(grid, i, j);
          maxArea = Math.max(maxArea, currentArea);
        }
      }
    }
    return maxArea;
  }
  
  private int getArea(int[][] grid, int i, int j) {
    int currentArea = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{i, j});
    while (!queue.isEmpty()) {
      int[] removed = queue.remove();
      int currX = removed[0];
      int currY = removed[1];
      currentArea++;
      for (int[] dir : DIRS) {
        int newX = dir[0] + currX;
        int newY = dir[1] + currY;
        if (isValidCoordinate(grid, newX, newY) && grid[newX][newY] == 1) {
          queue.add(new int[]{newX, newY});
          grid[newX][newY] = 0;
        }
      }
    }
    return currentArea;
  }
  
  private boolean isValidCoordinate(int[][] grid, int i, int j) {
    return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
  }
}
