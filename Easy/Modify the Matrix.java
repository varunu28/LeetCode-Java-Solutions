class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int c = 0; c < cols; c++) {
            int max = -1;
            for (int r = 0; r < rows; r++) {
                max = Math.max(max, matrix[r][c]);
            }
            for (int r = 0; r < rows; r++) {
                matrix[r][c] = matrix[r][c] == -1 ? max : matrix[r][c];
            }
        }
        return matrix;
    }
}
