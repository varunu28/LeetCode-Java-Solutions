class Solution {
  
  public int countBattleships(char[][] board) {
    int count = 0;
    int rows = board.length;
    int cols = board[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == '.' || (i > 0 && board[i - 1][j] == 'X') || (j > 0 && board[i][j - 1] == 'X')) {
          continue;
        }
        count++;
      }
    }
    return count;
  }
}
