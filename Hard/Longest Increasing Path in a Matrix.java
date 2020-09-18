class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, i, j, dp, Integer.MIN_VALUE));
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] matrix, int x, int y, int[][] dp, int prevVal) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= prevVal) {
            return 0;
        }
        
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        
        int temp = 0;
        for (int[] dir : dirs) {
            temp = Math.max(temp, dfs(matrix, x + dir[0], y + dir[1], dp, matrix[x][y]));
        }
        
        dp[x][y] = temp + 1;
        return dp[x][y];
    }
}
