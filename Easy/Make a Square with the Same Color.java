class Solution {

    int[][] DIRS = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public boolean canMakeSquare(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isPossible(grid, i, j, rows, cols)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPossible(char[][] grid, int i, int j, int rows, int cols) {
        int white = 0;
        int black = 0;
        int invalid = 0;
        for (int[] dir : DIRS) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newY >= 0 && newX < rows && newY < cols) {
                white += grid[newX][newY] == 'W' ? 1 : 0;
                black += grid[newX][newY] == 'B' ? 1 : 0;
            } else {
                invalid++;
            }
        }
        if (invalid > 0) {
            return false;
        }
        if (white == 4 || black == 4) {
            return true;
        }
        return white == 1 || black == 1;
    }
}
