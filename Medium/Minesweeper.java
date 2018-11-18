class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        
        updateBoard(board, row, col);
        
        return board;
    }
    
    private void updateBoard(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }
        
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        }
        
        if (board[row][col] == 'E') {
            int mineCount = getMineCount(board, row, col);
            if (mineCount == 0) {
                board[row][col] = 'B';
                updateBoard(board, row + 1, col);
                updateBoard(board, row, col + 1);
                updateBoard(board, row, col - 1);
                updateBoard(board, row - 1, col);
                updateBoard(board, row - 1, col - 1);
                updateBoard(board, row + 1, col + 1);
                updateBoard(board, row - 1, col + 1);
                updateBoard(board, row + 1, col - 1);
            }
            else {
                board[row][col] = (char) (mineCount + '0');
            }
        }
    }
    
    private int getMineCount(char[][] board, int row, int col) {
        int count = 0;
        
        if (row + 1 < board.length && board[row + 1][col] == 'M') {
            count++;
        } 
        if (row - 1 >= 0 && board[row - 1][col] == 'M') {
            count++;
        }
        if (col + 1 < board[0].length && board[row][col + 1] == 'M') {
            count++;
        }
        if (col - 1 >= 0 && board[row][col - 1] == 'M') {
            count++;
        }
        if (row + 1 < board.length && col + 1 < board[0].length && board[row + 1][col + 1] == 'M') {
            count++;
        }
        if (row + 1 < board.length && col - 1 >= 0 && board[row + 1][col - 1] == 'M') {
            count++;
        }
        if (row - 1 >= 0 && col + 1 < board[0].length && board[row - 1][col + 1] == 'M') {
            count++;
        }
        if (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1] == 'M') {
            count++;
        }
        
        return count;
    }
}
