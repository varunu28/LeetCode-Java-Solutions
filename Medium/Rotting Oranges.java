class Solution {
  private final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  
  public int orangesRotting(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();
    int nonRottenCount = 0;
    int numRows = grid.length;
    int numCols = grid[0].length;
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (grid[i][j] == 2) {
          queue.add(new int[]{i, j});
        } else if (grid[i][j] == 1) {
          nonRottenCount++;
        }
      }
    }
    int totalTime = 0;
    while (!queue.isEmpty() && nonRottenCount > 0) {
      int size = queue.size();
      while (size-- > 0) {
        int[] removed = queue.remove();
        for (int[] dir : DIRS) {
          int newX = removed[0] + dir[0];
          int newY = removed[1] + dir[1];
          if (newX >= 0 && newY >= 0 && newX < numRows && newY < numCols && grid[newX][newY] == 1) {
            grid[newX][newY] = 2;
            nonRottenCount--;
            queue.add(new int[]{newX, newY});
          }
        }
      }
      totalTime++;
    }
    return nonRottenCount == 0 ? totalTime : -1;
  }
}
