class Solution {
  int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
  public int numRookCaptures(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'R') {
          return getPawnCount(board, i, j);
        }
      }
    }
    return 0;
  }
  
  private int getPawnCount(char[][] board, int i, int j) {
    int count = 0;
    for (int[] dir : dirs) {
      int newX = i + dir[0];
      int newY = j + dir[1];
      while (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
        if (board[newX][newY] == 'p') {
          count++;
          break;
        }
        else if (board[newX][newY] == 'B') {
          break;
        }
        newX = newX + dir[0];
        newY = newY + dir[1];
      }
    }
    return count;
  }
}
