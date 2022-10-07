class Solution {
  
  private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

  public void gameOfLife(int[][] board) {
    int rows = board.length;
    int cols = board[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int liveNeighborCount = getLiveNeighbours(board, i, j);
        if (board[i][j] == 1) {
          if (liveNeighborCount < 2 || liveNeighborCount > 3) {
            board[i][j] = 2;
          }
        } else {
          if (liveNeighborCount == 3) {
            board[i][j] = 3;
          }
        }
      }
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == 2) {
          board[i][j] = 0;
        } else if (board[i][j] == 3) {
          board[i][j] = 1;
        }
      }
    }
  }
  
  private static int getLiveNeighbours(int[][] board, int i, int j) {
    int count = 0;
    for (int[] dir : DIRS) {
      int x = i + dir[0];
      int y = j + dir[1];
      if (isValidCell(board, x, y) && (board[x][y] == 1 || board[x][y] == 2)) {
        count++;
      }
    }
    return count;
  }
  
  private static boolean isValidCell(int[][] board, int i, int j) {
    return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
  }
}
