class Solution {
    public int minFlips(int[][] mat) {
        int result = recurse(mat, 0, 0, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int recurse(int[][] matrix, int row, int col, int moves) {
        if (col == matrix[0].length) {
            col = 0;
            row++;
        }
        if (row == matrix.length) {
            return isValid(matrix) ? moves : Integer.MAX_VALUE;
        }
        int notFlipped = recurse(matrix, row, col + 1, moves);
        flip(matrix, row, col);
        int flipped = recurse(matrix, row, col + 1, moves + 1);
        flip(matrix, row, col);
        return Math.min(notFlipped, flipped);
    }

    private boolean isValid(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private void flip(int[][] matrix, int row, int col) {
        matrix[row][col] ^= 1;
        if (row > 0) {
            matrix[row - 1][col] ^= 1;
        }
        if (col > 0) {
            matrix[row][col - 1] ^= 1;
        }
        if (row < matrix.length - 1) {
            matrix[row + 1][col] ^= 1;
        }
        if (col < matrix[0].length - 1) {
            matrix[row][col + 1] ^= 1;
        }
    }
}
