class Solution {
  private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int numEnclaves(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        result += grid[i][j];
        if (i * j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
          queue.add(new int[]{i, j});
        }
      }
    }
    while (!queue.isEmpty()) {
      int[] removed = queue.remove();
      int x = removed[0];
      int y = removed[1];
      if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] != 1) {
        continue;
      }
      grid[x][y] = 0;
      result--;
      for (int[] dir : DIRS) {
        queue.add(new int[]{x + dir[0], y + dir[1]});
      }
    }
    return result;
  }
}
