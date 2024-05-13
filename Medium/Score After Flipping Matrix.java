class Solution {
    public int matrixScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        for (int j = 1; j < cols; j++) {
            int countZero = 0;
            for (int[] row : grid) {
                if (row[j] == 0) {
                    countZero++;
                }
            }
            if(countZero > rows-countZero) {
                for(int i = 0; i < rows; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        int score = 0;
        for (int[] row : grid) {
            for (int j = 0; j < cols; j++) {
                score += row[j] << (cols - j - 1);
            }
        }
        return score;
    }
}
