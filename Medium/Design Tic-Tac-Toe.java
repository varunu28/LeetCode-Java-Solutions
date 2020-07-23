class TicTacToe {

  /** Initialize your data structure here. */
  int[][] board;
  Map<Integer, Map<Integer, Integer>> rowMap;
  Map<Integer, Map<Integer, Integer>> colMap;
  Map<Integer, Integer> leftDiagonalMap;
  Map<Integer, Integer> rightDiagonalMap;
  int n;
  public TicTacToe(int n) {
    board = new int[n][n];
    rowMap = new HashMap<>();
    colMap = new HashMap<>();
    leftDiagonalMap = new HashMap<>();
    rightDiagonalMap = new HashMap<>();
    this.n = n;
  }

  /** Player {player} makes a move at ({row}, {col}).
      @param row The row of the board.
      @param col The column of the board.
      @param player The player, can be either 1 or 2.
      @return The current winning condition, can be either:
              0: No one wins.
              1: Player 1 wins.
              2: Player 2 wins. */
  public int move(int row, int col, int player) {
    if (!rowMap.containsKey(row)) {
      Map<Integer, Integer> map = new HashMap<>();
      rowMap.put(row, map);
    }
    rowMap.get(row).put(player, rowMap.get(row).getOrDefault(player, 0) + 1);
    if (ifWinner(rowMap.get(row), player)) {
      return player;
    }
    if (!colMap.containsKey(col)) {
      Map<Integer, Integer> map = new HashMap<>();
      colMap.put(col, map);
    }
    colMap.get(col).put(player, colMap.get(col).getOrDefault(player, 0) + 1);
    if (ifWinner(colMap.get(col), player)) {
      return player;
    }
    if (row == col) {
      leftDiagonalMap.put(player, leftDiagonalMap.getOrDefault(player, 0) + 1);
    }
    if (ifWinner(leftDiagonalMap, player)) {
      return player;
    }
    if (row + col == n - 1) {
      rightDiagonalMap.put(player, rightDiagonalMap.getOrDefault(player, 0) + 1);
    }
    if (ifWinner(rightDiagonalMap, player)) {
      return player;
    }
    return 0;
  }
  
  private boolean ifWinner(Map<Integer, Integer> map, int player) {
    if (map.size() > 1) {
      return false;
    }
    return map.values().stream().reduce(0, Integer::sum) == n;
  }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
