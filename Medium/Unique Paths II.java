class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        Integer[][] dp = new Integer[rows][cols];
        return recurse(dp, rows - 1, cols - 1, obstacleGrid);
    }

    private int recurse(Integer[][] dp, int row, int col, int[][] obstacleGrid) {
        if (row >= 0 && col >= 0 && obstacleGrid[row][col] == 1) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        if (dp[row][col] != null) {
            return dp[row][col];
        }
        dp[row][col] = recurse(dp, row - 1, col, obstacleGrid) + recurse(dp, row, col - 1, obstacleGrid);
        return dp[row][col];
    }   
}
