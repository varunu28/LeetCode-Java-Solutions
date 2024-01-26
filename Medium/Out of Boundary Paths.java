class Solution {

    private static final int MOD = 1000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[m][n][maxMove + 1];
        return findPaths(m, n, maxMove, startRow, startColumn, dp);
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn, Integer[][][] dp) {
        if (startRow == m || startColumn == n || startRow < 0 || startColumn < 0) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
        if (dp[startRow][startColumn][maxMove] != null) {
            return dp[startRow][startColumn][maxMove];
        }
        return dp[startRow][startColumn][maxMove] = (
            (findPaths(m, n, maxMove - 1, startRow - 1, startColumn, dp) +
            findPaths(m, n, maxMove - 1, startRow + 1, startColumn, dp)) % MOD +
            (findPaths(m, n, maxMove - 1, startRow, startColumn - 1, dp) +
            findPaths(m, n, maxMove - 1, startRow, startColumn + 1, dp)) % MOD) % MOD; 
    }
}
