class Solution {
  private static final int[][] DIRS = {{1, 0},  {0, 1}, {-1, 0}, {0, -1}};

  public int[][] updateMatrix(int[][] mat) {
    int numRows = mat.length;
    int numCols = mat[0].length;
    int[][] distances = new int[numRows][numCols];
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (mat[i][j] == 0) {
          queue.add(new int[]{i, j});
        } else {
          distances[i][j] = Integer.MAX_VALUE;
        }
      }
    }
    while (!queue.isEmpty()) {
      int[] removed = queue.remove();
      int currX = removed[0];
      int currY = removed[1];
      for (int[] dir : DIRS) {
        int newX = currX + dir[0];
        int newY = currY + dir[1];
        if (newX >= 0 && newY >= 0 && newX < numRows && newY < numCols && distances[newX][newY] > distances[currX][currY] + 1) {
          queue.add(new int[]{newX, newY});
          distances[newX][newY] = distances[currX][currY] + 1;
        }
      }
    }
    return distances;
  }
}
