class Solution {
  public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    if (n == 0 || grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
      return -1;
    }
    Queue<int[]> queue = new LinkedList<>();
    int numberOfSteps = 0;
    boolean[][] visited = new boolean[n][n];
    queue.add(new int[] {0, 0});
    visited[0][0] = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] removed = queue.remove();
        if (removed[0] == n - 1 && removed[1] == n - 1) {
          return numberOfSteps + 1;
        }
        for (int[] dir : EIGHT_DIRS) {
          int newX = removed[0] + dir[0];
          int newY = removed[1] + dir[1];
          if (newX >= 0
              && newX < n
              && newY >= 0
              && newY < n
              && !visited[newX][newY]
              && grid[newX][newY] == 0) {
            queue.add(new int[] {newX, newY});
            visited[newX][newY] = true;
          }
        }
      }
      numberOfSteps++;
    }
    return -1;
  }

  private static final int[][] EIGHT_DIRS = {
    {0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
}
