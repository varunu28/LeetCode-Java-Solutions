class Solution {
  private final int[][] DIRS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
  
  public int maxDistance(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();
    int numRows = grid.length;
    int numCols = grid[0].length;
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (grid[i][j] == 1) {
          queue.add(new int[]{i, j});
        }
      }
    }
    if (queue.isEmpty() || queue.size() == numRows * numCols) {
      return -1;
    }
    int distance = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] removed = queue.remove();
        for (int[] dir : DIRS) {
          int x = removed[0] + dir[0];
          int y = removed[1] + dir[1];
          if (x < 0 || y < 0 || x >= numRows || y >= numCols || grid[x][y] == 1) {
            continue;
          }
          grid[x][y] = 1;
          queue.add(new int[]{x, y});
        }
      }
      distance++;
    }
    return distance - 1; 
  }
}
