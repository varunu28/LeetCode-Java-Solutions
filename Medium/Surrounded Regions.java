class Solution {
  public void solve(char[][] board) {
    if (board == null || board.length == 0) {
      return;
    }
    int rows = board.length;
    int cols = board[0].length;
    List<List<Integer>> borders = new ArrayList<>();
    for (int r = 0; r < rows; r++) {
      borders.add(Arrays.asList(r, 0));
      borders.add(Arrays.asList(r, cols - 1));
    }
    for (int c = 0; c < cols; c++) {
      borders.add(Arrays.asList(0, c));
      borders.add(Arrays.asList(rows - 1, c));
    }
    for (List<Integer> border : borders) {
      dfs(board, border.get(0), border.get(1), rows, cols);
    }
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (board[r][c] == 'O') {
          board[r][c] = 'X';
        }
        if (board[r][c] == 'E') {
          board[r][c] = 'O';
        }
      }
    }
  }
  
  private void dfs(char[][] board, int row, int col, int rows, int cols) {
    if (board[row][col] != 'O') {
      return;
    }
    board[row][col] = 'E';
    if (col < cols - 1) {
      dfs(board, row, col + 1, rows, cols);
    }
    if (row < rows - 1) {
      dfs(board, row + 1, col, rows, cols);
    }
    if (col > 0) {
      dfs(board, row, col - 1, rows, cols);
    }
    if (row > 0) {
      dfs(board, row - 1, col, rows, cols);
    }
  }
}
