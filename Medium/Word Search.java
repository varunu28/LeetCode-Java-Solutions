class Solution {
  int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  public boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (dfs(board, i, j, word, 0, new boolean[rows][cols], rows, cols)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean dfs(char[][] board, int x, int y, String s, int idx, 
                      boolean[][] visited, int rows, int cols) {
    if (idx == s.length()) {
      return true;
    }
    if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y]) {
      return false;
    }
    if (s.charAt(idx) != board[x][y]) {
      return false;
    }
    visited[x][y] = true;
    for (int[] dir : dirs) {
      if (dfs(board, x + dir[0], y + dir[1], s, idx + 1, visited, rows, cols)) {
        return true;
      }
    }
    visited[x][y] = false;
    return false;
  }
}
