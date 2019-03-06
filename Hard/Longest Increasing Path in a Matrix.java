class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int max = 0;
        dp = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, getIncreasingPathLength(matrix, i, j, Integer.MIN_VALUE));
            }
        }
        
        return max;
    }
    
    private int getIncreasingPathLength(int[][] matrix, int row, int col, int prev) {
        if (row < 0 || 
            col < 0 || 
            row >= matrix.length || 
            col >= matrix[0].length || 
            matrix[row][col] <= prev) {
            return 0;
        }
        
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        
        int up = getIncreasingPathLength(matrix, row - 1, col, matrix[row][col]);
        int down = getIncreasingPathLength(matrix, row + 1, col, matrix[row][col]);
        int right = getIncreasingPathLength(matrix, row, col + 1, matrix[row][col]);
        int left = getIncreasingPathLength(matrix, row, col - 1, matrix[row][col]);
        
        dp[row][col] = 1 + Math.max(Math.max(up, down), Math.max(right, left));
        
        return dp[row][col];
    }
}
