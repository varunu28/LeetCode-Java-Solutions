class Solution {
  int[][] dirs = {{1, 0}, {0, 1}, {1, 1}, {-1, -1}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}};
  public void gameOfLife(int[][] board) {
    int rows = board.length;
    int cols = board[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int count = getLiveNeighbourCount(board, i, j);
        if (board[i][j] == 1) {
          if (count < 2 || count > 3) {
            board[i][j] = -1;
          }
        }
        else {
          if (count == 3) {
            board[i][j] = 2;
          }
        }
      }
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j] = board[i][j] > 0 ? 1 : 0;
      }
    }
  }
  
  private int getLiveNeighbourCount(int[][] board, int x, int y) {
    int count = 0;
    for (int[] dir : dirs) {
      int newX = x + dir[0];
      int newY = y + dir[1];
      if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && Math.abs(board[newX][newY]) == 1) {
        count++;
      }
    }
    return count;
  }
}
