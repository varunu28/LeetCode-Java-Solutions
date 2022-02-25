class Solution {
  
  private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  
  public int numIslands(char[][] grid) {
    int countOfIslands = 0;
    int numOfRows = grid.length;
    int numOfCols = grid[0].length;
    boolean[][] visited = new boolean[numOfRows][numOfCols];
    for (int i = 0; i < numOfRows; i++) {
      for (int j = 0; j < numOfCols; j++) {
        if (!visited[i][j] && grid[i][j] == '1') {
          Queue<int[]> queue = new LinkedList<>();
          queue.add(new int[]{i, j});
          while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
              int[] removed = queue.remove();
              int currX = removed[0];
              int currY = removed[1];
              visited[currX][currY] = true;
              for (int[] dir : DIRS) {
                int newX = currX + dir[0];
                int newY = currY + dir[1];
                if (newX >= 0 && newY >= 0 && newX < numOfRows && newY < numOfCols && !visited[newX][newY] && grid[newX][newY] == '1') {
                  queue.add(new int[]{newX, newY});
                  visited[newX][newY] = true;
                }
              }
            }
          }
          countOfIslands++;
        }
      }
    }
    return countOfIslands;
  }
}
