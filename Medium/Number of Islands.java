class Solution {
  
  private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  
  public int numIslands(char[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];
    int islandCount = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          Queue<int[]> queue = new LinkedList<>();
          queue.add(new int[]{i, j});
          visited[i][j] = true;
          while (!queue.isEmpty()) {
            int[] removed = queue.remove();
            for (int[] dir : DIRS) {
              int newX = removed[0] + dir[0];
              int newY = removed[1] + dir[1];
              if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && !visited[newX][newY] && grid[newX][newY] == '1') {
                visited[newX][newY] = true;
                queue.add(new int[]{newX, newY});
              }
            }
          }
          islandCount++;
        }
      }
    }
    return islandCount;
  }
}
