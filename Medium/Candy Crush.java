class Solution {
  public int[][] candyCrush(int[][] board) {
    int rows = board.length;
    int cols = board[0].length;
    boolean flag = false;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c + 2 < cols; c++) {
        int val = Math.abs(board[r][c]);
        if (val != 0 && val == Math.abs(board[r][c + 1]) && val == Math.abs(board[r][c + 2])) {
          board[r][c] = board[r][c + 1] = board[r][c + 2] = -val;
          flag = true;
        }
      }
    }
    for (int r = 0; r + 2 < rows; r++) {
      for (int c = 0; c < cols; c++) {
        int val = Math.abs(board[r][c]);
        if (val != 0 && val == Math.abs(board[r + 1][c]) && val == Math.abs(board[r + 2][c])) {
          board[r][c] = board[r + 1][c] = board[r + 2][c] = -val;
          flag = true;
        }
      }
    }
    for (int c = 0; c < cols; c++) {
      int currRow = rows - 1;
      for (int r = rows - 1; r >= 0; r--) {
        if (board[r][c] > 0) {
          board[currRow--][c] = board[r][c];
        }
      }
      while (currRow >= 0) {
        board[currRow--][c] = 0;
      }
    }
    return flag ? candyCrush(board) : board;
  }
}
