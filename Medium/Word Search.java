class Solution {
  
  private final int[][] DIRS = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
  
  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (found(board, i, j, word, 0, m, n)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean found(char[][] board, int x, int y, String word, int idx, int m, int n) {
    if (idx == word.length()) {
      return true;
    }
    if (x < 0 || x == m || y < 0 || y == n || board[x][y] != word.charAt(idx)) {
      return false;
    }
    board[x][y] = '#';
    for (int[] dir : DIRS) {
      if (found(board, x + dir[0], y + dir[1], word, idx + 1, m, n)) {
        return true;
      }
    }
    board[x][y] = word.charAt(idx);
    return false;
  }
}
