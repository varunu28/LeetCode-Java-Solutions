class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};
    public char[][] updateBoard(char[][] board, int[] click) {    
        dfs(board, click[0], click[1]);
        return board;
    }
    
    private void dfs(char[][] board, int x, int y) {
        if (!isCoordinateValid(x, y, board)) {
            return;
        }
        
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        }
        
        if (board[x][y] == 'E') {
            int mineCount = getAdjacentMineCount(board, x, y);
            if (mineCount == 0) {
                board[x][y] = 'B';
                for (int[] dir : dirs) {
                    dfs(board, x + dir[0], y + dir[1]);
                }
            }
            else {
                board[x][y] = (char) (mineCount + '0');
            }
        }    
    }
    
    private boolean isCoordinateValid(int x, int y, char[][] board) {
        return !(x < 0 || x >= board.length || y < 0 || y >= board[0].length);
    }
    
    private int getAdjacentMineCount(char[][] board, int x, int y) {
        int count = 0;
        for (int[] dir : dirs) {
            if (isCoordinateValid(x + dir[0], y + dir[1], board) && board[x + dir[0]][y + dir[1]] == 'M') {
                count++;
            }
        }
        
        return count;
    }
}
