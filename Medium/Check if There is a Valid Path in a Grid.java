class Solution {
  public boolean hasValidPath(int[][] grid) {
    int[][][] dirs = {
      {{0, -1}, {0, 1}},
      {{-1, 0}, {1, 0}},
      {{0, -1}, {1, 0}},
      {{0, 1}, {1, 0}},
      {{0, -1}, {-1, 0}},
      {{0, 1}, {-1, 0}}
    };
    int rows = grid.length;
    int cols = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[rows][cols];
    queue.add(new int[]{0, 0});
    visited[0][0] = true;
    while (!queue.isEmpty()) {
      int[] curr = queue.remove();
      int x = curr[0];
      int y = curr[1];
      int num = grid[x][y] - 1;
      for (int[] dir : dirs[num]) {
        int newX = x + dir[0];
        int newY = y + dir[1];
        // Check if valid co-ordinate
        if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visited[newX][newY]) {
          for (int[] prevDir : dirs[grid[newX][newY] - 1]) {
            // Check if connected to previous direction
            if (newX + prevDir[0] == x && newY + prevDir[1] == y) {
              visited[newX][newY] = true;
              queue.add(new int[]{newX, newY});
            }
          }
        }
      }
    }
    return visited[rows - 1][cols - 1];
  }
}
