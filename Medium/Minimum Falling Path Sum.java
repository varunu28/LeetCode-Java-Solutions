class Solution {
    private static final int[][] DIRS = {{1, -1}, {1, 0}, {1, 1}};

    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Integer[][] dp = new Integer[rows + 1][cols + 1];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            result = Math.min(result, recurse(matrix, 0, i, rows, cols, dp));
        }
        return result;
    }

    private int recurse(int[][] matrix, int row, int col, int rows, int cols, Integer[][] dp) {
        if (row == rows - 1) {
            return matrix[row][col];
        }
        if (dp[row][col] != null) {
            return dp[row][col];
        }
        int result = Integer.MAX_VALUE;
        for (int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols) {
                continue;
            }
            result = Math.min(result, matrix[row][col] + recurse(matrix, newRow, newCol, rows, cols, dp));
        }
        return dp[row][col] = result;
    }
}
