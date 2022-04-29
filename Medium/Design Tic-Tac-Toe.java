class TicTacToe {

  private int n;
  private Map<Integer, Map<Integer, Integer>> rowMapping;
  private Map<Integer, Map<Integer, Integer>> colMapping;
  private Map<Integer, Map<Integer, Integer>> diagonalMapping;
  
  private final int LEFT_DIAGONAL = 1;
  private final int RIGHT_DIAGONAL = -1;
  
  public TicTacToe(int n) {
    this.n = n;
    this.rowMapping = new HashMap<>();
    this.colMapping = new HashMap<>();
    this.diagonalMapping = new HashMap<>();
    this.diagonalMapping.put(LEFT_DIAGONAL, new HashMap<>());
    this.diagonalMapping.put(RIGHT_DIAGONAL, new HashMap<>());
  }

  public int move(int row, int col, int player) {
    recordMove(row, col, player);
    if (isWinnerFound(row, col, player)) {
      return player;
    }
    return 0;
  }
  
  private void recordMove(int row, int col, int player) {
    this.rowMapping.computeIfAbsent(row, k -> new HashMap<>());
    this.colMapping.computeIfAbsent(col, k -> new HashMap<>());
    this.rowMapping.get(row).put(player, this.rowMapping.get(row).getOrDefault(player, 0) + 1);
    this.colMapping.get(col).put(player, this.colMapping.get(col).getOrDefault(player, 0) + 1);
    if (row == col) {
      this.diagonalMapping.get(LEFT_DIAGONAL)
        .put(player, this.diagonalMapping.get(LEFT_DIAGONAL).getOrDefault(player, 0) + 1);
    } 
    if (row + col + 1 == this.n) {
      this.diagonalMapping.get(RIGHT_DIAGONAL)
        .put(player, this.diagonalMapping.get(RIGHT_DIAGONAL).getOrDefault(player, 0) + 1);
    }
  }
  
  private boolean isWinnerFound(int row, int col, int player) {
    return this.rowMapping.get(row).get(player) == this.n ||
      this.colMapping.get(col).get(player) == this.n ||
      this.diagonalMapping.get(LEFT_DIAGONAL).getOrDefault(player, 0) == this.n ||
      this.diagonalMapping.get(RIGHT_DIAGONAL).getOrDefault(player, 0) == this.n;
  }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
