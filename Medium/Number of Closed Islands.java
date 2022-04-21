class Solution {
  private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  
  public int closedIsland(int[][] grid) {
    int closedIslandCount = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0 && isSurroundedSuccessfully(grid, i, j)) {
          closedIslandCount++;
        }
      }
    }
    return closedIslandCount;
  }
  
  private boolean isSurroundedSuccessfully(int[][] grid, int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{i, j});
    boolean surroundingCheck = true;
    while (!queue.isEmpty()) {
      int[] removed = queue.remove();
      int x = removed[0];
      int y = removed[1];
      if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
        surroundingCheck = false;
        continue;
      }
      if (grid[x][y] == 1) {
        continue;
      }
      grid[x][y] = 1;
      for (int[] dir : DIRS) {
        int newX = x + dir[0];
        int newY = y + dir[1];
        queue.add(new int[]{newX, newY});
      }
    }
    return surroundingCheck;
  }
}
