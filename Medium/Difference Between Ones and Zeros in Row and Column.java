class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] rowCount = new int[rows][2];
        int[][] colCount = new int[cols][2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rowCount[i][0] += grid[i][j] == 1 ? 1 : 0;
                rowCount[i][1] += grid[i][j] != 1 ? 1 : 0;
                colCount[j][0] += grid[i][j] == 1 ? 1 : 0;
                colCount[j][1] += grid[i][j] != 1 ? 1 : 0;
            }
        }
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = rowCount[i][0] + colCount[j][0] - rowCount[i][1] - colCount[j][1];
            }
        }
        return result;
    }
}
