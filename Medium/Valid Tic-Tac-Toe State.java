class Solution {
    public boolean validTicTacToe(String[] board) {
        if (hasWon(board, 'X')) {
            return getCount(board, 'X') - getCount(board, 'O') == 1;
        }

        if (hasWon(board, 'O')) {
            return getCount(board, 'X') - getCount(board, 'O') == 0;
        }

        int diff = getCount(board, 'O') - getCount(board, 'X');

        return diff == 0 || diff == -1;
    }

    private boolean hasWon(String[] board, char player) {
        boolean b1 = (board[0].charAt(0) == player && board[0].charAt(1) == player && board[0].charAt(2) == player);
        boolean b2 = (board[0].charAt(0) == player && board[1].charAt(0) == player && board[2].charAt(0) == player);
        boolean b3 = (board[0].charAt(1) == player && board[1].charAt(1) == player && board[2].charAt(1) == player);
        boolean b4 = (board[0].charAt(2) == player && board[1].charAt(2) == player && board[2].charAt(2) == player);
        boolean b5 = (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player);
        boolean b6 = (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player);
        boolean b7 = (board[1].charAt(0) == player && board[1].charAt(1) == player && board[1].charAt(2) == player);
        boolean b8 = (board[2].charAt(0) == player && board[2].charAt(1) == player && board[2].charAt(2) == player);

        return b1 || b2 || b3 || b4 || b5|| b6 || b7 || b8;
    }

    private int getCount(String[] board, char player) {
        int count = 0;

        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == player) {
                    count++;
                }
            }
        }

        return count;
    }
}
