class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i + 1 < rows && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
                if (j + 1 < cols && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
