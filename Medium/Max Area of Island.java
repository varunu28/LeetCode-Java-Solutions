class Solution {
  private final int[][] DIRS = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
  
  public int maxAreaOfIsland(int[][] grid) {
    int area = 0;
    int rows = grid.length; 
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          Queue<int[]> queue = new LinkedList<>();
          int currArea = 0;
          queue.add(new int[]{i, j});
          visited[i][j] = true;
          while (!queue.isEmpty()) {
            int[] removed = queue.remove();
            currArea++;
            for (int[] dir : DIRS) {
              int x = removed[0] + dir[0];
              int y = removed[1] + dir[1];
              if (x >= 0 && y >= 0 && x < rows && y < cols && !visited[x][y] && grid[x][y] == 1) {
                queue.add(new int[]{x, y});
                visited[x][y] = true;
              }
            }
          }
          area = Math.max(area, currArea);
        }
      }
    }
    return area;
  }
}
