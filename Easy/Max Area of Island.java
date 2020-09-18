class Solution {
  int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  public int maxAreaOfIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int maxArea = 0;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        maxArea = Math.max(maxArea, helper(grid, i, j, m, n, visited));
      }
    }
    return maxArea;
  }
  
  private int helper(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
    if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
      return 0;
    }
    int curr = 1;
    visited[i][j] = true;
    for (int[] dir : dirs) {
      curr += helper(grid, i + dir[0], j + dir[1], m, n, visited);
    }
    return curr;
  }
}
