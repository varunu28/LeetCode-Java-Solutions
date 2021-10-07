class Solution {
  public static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  
  public boolean exist(char[][] board, String word) {
    char[] letters = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfs(board, 0, letters, i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, int idx, char[] letters, int i, int j) {
    if (idx == letters.length) {
      return true;
    }
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
      return false;
    }
    if (board[i][j] != letters[idx]) {
      return false;
    }
    board[i][j] ^= 256;
    boolean exists = false;
    for (int[] dir : DIRS) {
      exists = exists || dfs(board, idx + 1, letters, i + dir[0], j + dir[1]);
    }
    board[i][j] ^= 256;
    return exists;
  }
}
