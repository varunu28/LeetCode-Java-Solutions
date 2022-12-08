class Solution {
    public int[][] largestLocal(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] result = new int[rows - 2][cols - 2];
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        result[i][j] = Math.max(result[i][j], grid[k][l]);
                    }
                }
            }
        }
        return result;
    }
}
