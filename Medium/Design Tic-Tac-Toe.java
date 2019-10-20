class TicTacToe {

    /** Initialize your data structure here. */
    private int[] rows;
    private int[] cols;
    private int leftDiagCount;
    private int rightDiagCount;
    private int n;

    public TicTacToe(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        leftDiagCount = 0;
        rightDiagCount = 0;
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
        int moveValue = player == 1 ? 1 : -1;
        rows[row] += moveValue;
        cols[col] += moveValue;
        if (row == col) {
            leftDiagCount += moveValue;
        }
        if (col == n - row - 1) {
            rightDiagCount += moveValue;
        }
        if (
            Math.abs(rows[row]) == n ||
            Math.abs(cols[col]) == n ||
            Math.abs(leftDiagCount) == n || 
            Math.abs(rightDiagCount) == n
        ) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
