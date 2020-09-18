class Solution {
  public int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  public boolean exist(char[][] board, String word) {
    if (board.length == 0 || board[0].length == 0) {
      return false;
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (exists(board, i, j, word, 0, new boolean[board.length][board[0].length])) {
          return true;
        }
      }
    }
    return false;
  } 
  
  private boolean exists(char[][] board, int i, int j, String word, int idx, boolean[][] visited) {
    if (idx == word.length()) {
      return true;
    }
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(idx) != board[i][j]) {
      return false;
    }
    visited[i][j] = true;
    for (int[] dir : dirs) {
      if (exists(board, i + dir[0], j + dir[1], word, idx + 1, visited)) {
        return true;
      }
    }
    visited[i][j] = false;
    return false;
  }
}
