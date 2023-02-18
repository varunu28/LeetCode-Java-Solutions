class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        int rowIdx = 0;
        int colIdx = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = mat[rowIdx][colIdx++];
                if (colIdx == n) {
                    colIdx = 0;
                    rowIdx++;
                }
            }
        }
        return result;
    }
}
