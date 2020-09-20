class Solution {
  int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  public int uniquePathsIII(int[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int rows = grid.length;
    int cols = grid[0].length;
    int startX = 0;
    int startY = 0;
    int numOfEmptySquare = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1) {
          startX = i;
          startY = j;
        }
        if (grid[i][j] == 0) {
          numOfEmptySquare++;
        }
      }
    }
    int[] count = {0};
    helper(grid, startX, startY, numOfEmptySquare, 0, new boolean[rows][cols], count);
    return count[0];
  }
  
  private void helper(
    int[][] grid, int startX, int startY, int numOfEmptySquare,
    int currEmptySquare, boolean[][] visited, int[] count
  ) {
    if (startX < 0 || startX >= grid.length || startY < 0 || startY >= grid[0].length || grid[startX][startY] == -1 || visited[startX][startY]) {
      return;
    }
    if (grid[startX][startY] == 2) {
      if (currEmptySquare == numOfEmptySquare) {
        count[0]++;
      }
      return;
    }
    visited[startX][startY] = true;
    for (int[] dir : dirs) {
      helper(grid, startX + dir[0], startY + dir[1], numOfEmptySquare, (grid[startX][startY] == 0 ? currEmptySquare + 1 : currEmptySquare), visited, count);
    }
    visited[startX][startY] = false;
  }
}

