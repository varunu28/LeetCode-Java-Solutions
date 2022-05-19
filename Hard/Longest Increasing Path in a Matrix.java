class Solution {
  private final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int longestIncreasingPath(int[][] matrix) {
    int numRows = matrix.length;
    int numCols = matrix[0].length;
    int maxPathLength = 0;
    int[][] cache = new int[numRows][numCols];
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        maxPathLength = Math.max(maxPathLength, helper(matrix, numRows, numCols, i, j, cache));
      }
    }
    return maxPathLength;
  }

  private int helper(int[][] matrix, int numRows, int numCols, int i, int j, int[][] cache) {
    if (cache[i][j] != 0) {
      return cache[i][j];
    }
    for (int[] dir : DIRS) {
      int x = i + dir[0];
      int y = j + dir[1];
      if (x >= 0 && y >= 0 && x < numRows && y < numCols && matrix[x][y] > matrix[i][j]) {
        cache[i][j] = Math.max(cache[i][j], helper(matrix, numRows, numCols, x, y, cache));
      }
    }
    return ++cache[i][j];
  }
}
