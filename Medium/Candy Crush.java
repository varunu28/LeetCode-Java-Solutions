class Solution {
    public int[][] candyCrush(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean flag = false;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j + 2 < cols; j++) {
                int val = Math.abs(board[i][j]);
                if (val != 0 && val == Math.abs(board[i][j + 1]) && val == Math.abs(board[i][j + 2])) {
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -val;
                    flag = true;
                }
            }
        }
        
        for (int i = 0; i + 2 < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = Math.abs(board[i][j]);
                if (val != 0 && val == Math.abs(board[i + 1][j]) && val == Math.abs(board[i + 2][j])) {
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -val;
                    flag = true;
                }
            }
        }
        
        for (int i = 0; i < cols; ++i) {
            int rightRow = rows - 1;
            for (int j = rows - 1; j >= 0; --j) {
                if (board[j][i] > 0) {
                    board[rightRow--][i] = board[j][i];
                }
            }
            
            while (rightRow >= 0) {
                board[rightRow--][i] = 0;
            }
        }
        
        return flag ? candyCrush(board) : board;
    }
}
