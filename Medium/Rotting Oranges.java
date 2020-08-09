class Solution {
  int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
  public final int VISITED = -1;
  public int orangesRotting(int[][] grid) {
    int minutes = 0;
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 2) {
          queue.add(new int[]{i, j});
        }
      }
    }
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] removed = queue.remove();
        for (int[] dir : dirs) {
          int newX = removed[0] + dir[0];
          int newY = removed[1] + dir[1];
          if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
            grid[newX][newY] = 2;
            queue.add(new int[]{newX, newY});
          }
        }
        grid[removed[0]][removed[1]] = VISITED;
      }
      minutes++;
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          return -1;
        }
      }
    }
    return minutes > 0 ? minutes - 1 : 0;
  }
}
