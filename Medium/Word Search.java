class Solution {
    
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isFound(board, word, 0, i, j, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isFound(char[][] board, String word, int idx, int row, int col, int m, int n) {
        if (idx == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= m || col >= n || board[row][col] != word.charAt(idx)) {
            return false;
        }
        board[row][col] ^= 256;
        boolean result = false;
        for (int[] dir : DIRS) {
            result = result || isFound(board, word, idx + 1, row + dir[0], col + dir[1], m, n);
        }
        board[row][col] ^= 256;
        return result;
    }
}
