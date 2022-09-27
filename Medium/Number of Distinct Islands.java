class Solution {
  public int numDistinctIslands(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];
    Set<String> islands = new HashSet<>();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        StringBuilder currIsland = new StringBuilder();
        dfs(grid, row, col, visited, currIsland, '0');
        if (currIsland.length() == 0) {
          continue;
        }
        islands.add(currIsland.toString());
      }
    }
    return islands.size();
  }
  
  private void dfs(int[][] grid, int row, int col, boolean[][] visited, StringBuilder currIsland, char direction) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
      return;
    }
    if (visited[row][col] || grid[row][col] == 0) {
      return;
    }
    visited[row][col] = true;
    currIsland.append(direction);
    dfs(grid, row + 1, col, visited, currIsland, 'D');
    dfs(grid, row - 1, col, visited, currIsland, 'U');
    dfs(grid, row, col + 1, visited, currIsland, 'R');
    dfs(grid, row, col - 1, visited, currIsland, 'L');
    currIsland.append('0');
  }
}
