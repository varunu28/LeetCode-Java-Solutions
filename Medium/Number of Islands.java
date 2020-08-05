class Solution {
  public int numIslands(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int rows = grid.length;
    int cols = grid[0].length;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] visited = new boolean[rows][cols];
    int count = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          Queue<int[]> queue = new LinkedList<>();
          queue.add(new int[]{i, j});
          visited[i][j] = true;
          while (!queue.isEmpty()) {
            int[] removed = queue.remove();
            for (int[] dir : dirs) {
              int newX = removed[0] + dir[0];
              int newY = removed[1] + dir[1];
              if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || visited[newX][newY] || grid[newX][newY] == '0') {
                continue;
              }
              visited[newX][newY] = true;
              queue.add(new int[]{newX, newY});
            }
          }
          count++;
        }
      }
    }
    return count;
  }
}
