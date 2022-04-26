class Solution {
  private final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  
  public int countSubIslands(int[][] grid1, int[][] grid2) {
    int numRows = grid1.length;
    int numCols = grid1[0].length;
    int subIslandCount = 0;
    boolean[][] visited = new boolean[numRows][numCols];
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (!visited[i][j] && grid2[i][j] == 1) {
          Queue<int[]> queue = new LinkedList<>();
          queue.add(new int[]{i, j});
          boolean isSubisland = true;
          while (!queue.isEmpty()) {
            int[] removed = queue.remove();
            int x = removed[0];
            int y = removed[1];
            if (visited[x][y]) {
              continue;
            }
            if (grid1[x][y] != 1) {
              isSubisland = false;
            }
            visited[x][y] = true;
            for (int[] dir : DIRS) {
              int newX = x + dir[0];
              int newY = y + dir[1];
              if (newX >= 0 && newY >= 0 && newX < numRows && newY < numCols && !visited[newX][newY] && grid2[newX][newY] == 1) {
                queue.add(new int[]{newX, newY});
              }
            }
          }
          if (isSubisland) {
            subIslandCount++;
          }
        }
      }
    }
    return subIslandCount;
  }
}
