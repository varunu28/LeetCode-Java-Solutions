class Solution {
    
    private static final int MOD = 1000_000_007; 
    
    public int ways(String[] pizza, int k) {
        int rows = pizza.length;
        int cols = pizza[0].length();
        int[][] apples = new int[rows + 1][cols + 1];
        int[][][] dp = new int[k][rows][cols];
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                apples[row][col] = (pizza[row].charAt(col) == 'A' ? 1 : 0) + apples[row + 1][col] + apples[row][col + 1] - apples[row + 1][col + 1];
                dp[0][row][col] = apples[row][col] > 0 ? 1 : 0;
            }
        }
        
        for (int i = 1; i < k; i++) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    for (int nextRow = row + 1; nextRow < rows; nextRow++) {
                        if (apples[row][col] - apples[nextRow][col] > 0) {
                            dp[i][row][col] += dp[i - 1][nextRow][col];
                            dp[i][row][col] %= MOD;
                        }
                    }
                    for (int nextCol = col + 1; nextCol < cols; nextCol++) {
                        if (apples[row][col] - apples[row][nextCol] > 0) {
                            dp[i][row][col] += dp[i - 1][row][nextCol];
                            dp[i][row][col] %= MOD;
                        }
                    }
                }
            }
        }
        return dp[k - 1][0][0];
    }
}
