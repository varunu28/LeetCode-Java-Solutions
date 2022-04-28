class Solution {
  
  private final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  
  public int minimumEffortPath(int[][] heights) {
    if (heights.length == 1 && heights[0].length == 1) {
      return 0;
    }
    int leftBound = 0;
    int rightBound = 1000000;
    while (leftBound < rightBound) {
      int mid = (leftBound + rightBound) / 2;
      if (connected(heights, mid)) {
        rightBound = mid;
      } else {
        leftBound = mid + 1;
      }
    }
    return leftBound;
  }
  
  private boolean connected(int[][] heights, int targetEffort) {
    int numRows = heights.length;
    int numCols = heights[0].length;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] seen = new boolean[numRows][numCols];
    queue.add(new int[]{0, 0});
    seen[0][0] = true;
    while (!queue.isEmpty()) {
      int[] removed = queue.remove();
      int x = removed[0];
      int y = removed[1];
      if (x == numRows - 1 && y == numCols - 1) {
        return true;
      }
      for (int[] dir : DIRS) {
        int newX = x + dir[0];
        int newY = y + dir[1];
        if (newX >= 0 && newY >= 0 && newX < numRows && newY < numCols && !seen[newX][newY] && Math.abs(heights[x][y] - heights[newX][newY]) <= targetEffort) {
          queue.add(new int[]{newX, newY});
          seen[newX][newY] = true;
        }
      }
    }
    return false;
  }
}
