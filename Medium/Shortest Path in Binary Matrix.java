class Solution {
  private final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
  
  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid[0][0] == 1) {
      return -1;
    }
    int numRows = grid.length;
    int numCols = grid[0].length;
    boolean[][] visited = new boolean[numRows][numCols];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});
    visited[0][0] = true;
    int numOfSteps = 0;
    while (!queue.isEmpty()) {
      numOfSteps++;
      int size = queue.size();
      while (size-- > 0) {
        int[] removed = queue.remove();
        int x = removed[0];
        int y = removed[1];
        if (x == numRows - 1 && y == numCols - 1) {
          return numOfSteps;
        }
        for (int[] dir : DIRS) {
          int newX = x + dir[0];
          int newY = y + dir[1];
          if (newX >= 0 && newY >= 0 && newX < numRows && newY < numCols && !visited[newX][newY] && grid[newX][newY] == 0) {
            queue.add(new int[]{newX, newY});
            visited[newX][newY] = true;
          }
        }
      }
    }
    return -1;
  }
}
