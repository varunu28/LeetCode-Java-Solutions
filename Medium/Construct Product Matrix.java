class Solution {

    private static final int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] result = new int[rows][cols];
        long suffix = 1;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                result[i][j] = (int) suffix;
                suffix = (suffix * grid[i][j]) % MOD;
            }
        }
        long prefix = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = (int) (((long) result[i][j] * prefix) % MOD);
                prefix = (prefix * grid[i][j]) % MOD;
            }
        }
        return result;
    }
}
