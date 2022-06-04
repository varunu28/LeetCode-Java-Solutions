class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    char[][] board = new char[n][n];
    for (char[] row : board) {
      Arrays.fill(row, '.');
    }
    backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board, result, n);
    return result;
  }
  
  private void backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> columns, char[][] board, List<List<String>> result, int n) {
    if (row == n) {
      result.add(buildBoard(board, n));
      return;
    }
    for (int col = 0; col < n; col++) {
      int currDiagonal = row - col;
      int currAntiDiagonal = row + col;
      if (columns.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
        continue;
      }
      columns.add(col);
      diagonals.add(currDiagonal);
      antiDiagonals.add(currAntiDiagonal);
      board[row][col] = 'Q';

      backtrack(row + 1, diagonals, antiDiagonals, columns, board, result, n);
      
      columns.remove(col);
      diagonals.remove(currDiagonal);
      antiDiagonals.remove(currAntiDiagonal);
      board[row][col] = '.';
    }
  }
  
  private List<String> buildBoard(char[][] board, int n) {
    List<String> resultBoard = new ArrayList<>();
    for (int row = 0; row < n; row++) {
      String currentRow = new String(board[row]);
      resultBoard.add(currentRow);
    }
    return resultBoard;
  }
}
