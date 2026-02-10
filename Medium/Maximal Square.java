class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows + 1][cols + 1];
        int result = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    memo[i][j] = Math.min(
                        Math.min(memo[i][j - 1], memo[i - 1][j]), memo[i - 1][j - 1]
                    ) + 1;
                    result = Math.max(result, memo[i][j]);
                }
            }
        }
        return result * result;
    }
}
