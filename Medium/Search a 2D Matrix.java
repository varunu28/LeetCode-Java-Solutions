class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        while (row >= 0 && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                col--;
                if (col < 0) {
                    col = matrix[0].length - 1;
                    row--;
                }
            } else {
                row--;
            }
        }
        return false;
    }
}
