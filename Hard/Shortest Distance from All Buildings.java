class Solution {
  int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  public int shortestDistance(int[][] grid) {
    int numOfHouses = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        numOfHouses += grid[i][j] == 1 ? 1 : 0;
      }
    }
    int[] distance = {Integer.MAX_VALUE};
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          bfs(grid, i, j, numOfHouses, distance);
        }
      }
    }
    return distance[0] == Integer.MAX_VALUE ? -1 : distance[0];
  }
  
  private void bfs(int[][] grid, int i, int j, int numOfHouses, int[] distance) {
    int currDistance = 0;
    int numRows = grid.length;
    int numCols = grid[0].length;
    int houses = 0;
    boolean[][] visited = new boolean[numRows][numCols];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{i, j, 0});
    visited[i][j] = true;
    while (!queue.isEmpty() && houses != numOfHouses) {
      int size = queue.size();
      while (size-- > 0) {
        int[] removed = queue.remove();
        int x = removed[0];
        int y = removed[1];
        if (grid[x][y] == 1) {
          houses++;
          currDistance += removed[2];
        }
        else if (grid[x][y] == 0) {
          for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < numRows && newY >= 0 && newY < numCols && !visited[newX][newY]) {
              queue.add(new int[]{newX, newY, removed[2] + 1});
              visited[newX][newY] = true;
            }
          }
        }
      }
    }
    if (houses == numOfHouses) {
      distance[0] = Math.min(distance[0], currDistance);
    }
  }
}
