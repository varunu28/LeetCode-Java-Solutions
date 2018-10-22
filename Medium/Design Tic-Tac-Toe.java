class TicTacToe {

    /** Initialize your data structure here. */
    int[][] board;
    int n;
    boolean win;

    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];
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
        if (win) {
            return 0;
        }

        board[row][col] = player;

        boolean cCheck = columnCheck(col, n, player);
        boolean rCheck = rowCheck(row, n, player);
        boolean diagCheck = diagonalCheck(row, col, n, player);

        if (cCheck || rCheck  || diagCheck) {
            win = true;
            return player;
        }

        return 0;
    }

    private boolean diagonalCheck(int row, int col, int n, int player) {
        int count = 0;

        int rowNum = row;
        int colNum = col;

        while (rowNum < n && colNum < n) {
            if (board[rowNum][colNum] == player) {
                count++;
            }

            rowNum++;
            colNum++;
        }

        rowNum = row-1;
        colNum = col-1;

        while (rowNum >= 0 && colNum >= 0) {
            if (board[rowNum][colNum] == player) {
                count++;
            }

            rowNum--;
            colNum--;
        }

        if (count == n) {
            return true;
        }

        count = 0;
        rowNum = row;
        colNum = col;

        while (rowNum >= 0 && colNum < n) {
            if (board[rowNum][colNum] == player) {
                count++;
            }

            rowNum--;
            colNum++;
        }

        rowNum = row;
        colNum = col;

        while (rowNum < n && colNum >= 0) {
            if (board[rowNum][colNum] == player) {
                count++;
            }

            rowNum++;
            colNum--;
        }

        if (count == n+1) {
            return true;
        }

        return false;
    }

    private boolean rowCheck(int row, int n, int player) {
        for (int i=0; i<n;i++) {
            if (board[row][i] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean columnCheck(int col, int n, int player) {
        for (int i=0; i<n; i++) {
            if (board[i][col] != player) {
                return false;
            }
        }

        return true;
    }
}
