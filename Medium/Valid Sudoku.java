class Solution {
  public boolean isValidSudoku(char[][] board) {
    int N = 9;
    int[][] rows = new int[N][N];
    int[][] cols = new int[N][N];
    int[][] boxes = new int[N][N];
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        if (board[r][c] == '.') {
          continue;
        }
        int pos = board[r][c] - '1';
        if (rows[r][pos] == 1) {
          return false;
        }
        rows[r][pos] = 1;
        if (cols[c][pos] == 1) {
          return false;
        }
        cols[c][pos] = 1;
        int idx = (r / 3) * 3 + c / 3;
        if (boxes[idx][pos] == 1) {
          return false;
        }
        boxes[idx][pos] = 1;
      }
    }
    return true;
  }
}
