class Solution {
  public static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  
  public boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfs(board, word, 0, new boolean[rows][cols], i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, String word, int idx, boolean[][] visited, int i, int j) {
    if (idx == word.length()) {
      return true;
    }
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
        || board[i][j] != word.charAt(idx)) {
      return false;
    }
    visited[i][j] = true;
    boolean ans = false;
    for (int[] dir : DIRS) {
      ans = ans || dfs(board, word, idx + 1, visited, i + dir[0], j + dir[1]);
    }
    visited[i][j] = false;
    return ans;
  }
}
