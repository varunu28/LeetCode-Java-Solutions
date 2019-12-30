class Solution {
  int[][] dirs = {{-1, 0}, {0, -1}, {-1, -1}};
  final int MOD = 1000000007;
  int[][] dpSum;
  int[][] dpCount;
  public int[] pathsWithMaxScore(List<String> board) {
    int numRows = board.size();
    int numCols = board.get(0).length();
    dpSum = new int[numRows][numCols];
    dpCount = new int[numRows][numCols];
    dpCount[numRows - 1][numCols - 1] = 1;
    helper(board, numRows, numCols);
    return new int[]{dpSum[0][0], dpCount[0][0]};
  }
  
  private void helper(List<String> board, int numRows, int numCols) {
    for (int x = numRows - 1; x >= 0; x--) {
      for (int y = numCols - 1; y >= 0; y--) {
        if (dpCount[x][y] == 0) {
          continue;
        }
        for (int[] dir : dirs) {
          int newX = x + dir[0];
          int newY = y + dir[1];
          if (newX >= 0 && newY >= 0 && board.get(newX).charAt(newY) != 'X') {
            int tempSum = dpSum[x][y];
            if (board.get(newX).charAt(newY) != 'E') {
              tempSum += Character.getNumericValue(board.get(newX).charAt(newY));
            }
            if (tempSum > dpSum[newX][newY]) {
              dpCount[newX][newY] = dpCount[x][y];
              dpSum[newX][newY] = tempSum;
            }
            else if (tempSum == dpSum[newX][newY]) {
              dpCount[newX][newY] = (dpCount[newX][newY] + dpCount[x][y]) % MOD;
            }
          }
        }
      }
    }
  }
}
