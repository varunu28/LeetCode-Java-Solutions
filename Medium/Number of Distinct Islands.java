class Solution {
  Set<String> set;
  int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
  public int numDistinctIslands(int[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    set = new HashSet<>();
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (!visited[i][j]) {
          StringBuilder sb = new StringBuilder();
          dfs(grid, i, j, visited, sb, 0);
          if (sb.length() > 0) {
            set.add(sb.toString());
          }
        }
      }
    }
    return set.size();
  }
  
  private void dfs(int[][] grid, int x, int y, boolean[][] visited, StringBuilder sb, int currDir) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1 || visited[x][y]) {
      return;
    }
    sb.append(currDir);
    visited[x][y] = true;
    int curr = 1;
    for (int[] dir : dirs) {
      int newX = x + dir[0];
      int newY = y + dir[1];
      dfs(grid, newX, newY, visited, sb, curr++);
    }
    sb.append(0);
  }
}
