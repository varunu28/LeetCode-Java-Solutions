class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][][] cache = new Integer[m][n][n];
        return recurse(0, 0, n - 1, grid, cache);
    }

    private int recurse(int row, int colOne, int colTwo, int[][] grid, Integer[][][] cache) {
        if (colOne < 0 || colOne >= grid[0].length || colTwo < 0 || colTwo >= grid[0].length) {
            return 0;
        }
        if (cache[row][colOne][colTwo] != null) {
            return cache[row][colOne][colTwo];
        }
        int result = 0;
        result += grid[row][colOne];
        if (colOne != colTwo) {
            result += grid[row][colTwo];
        }
        if (row != grid.length - 1) {
            int max = 0;
            for (int c1 = colOne - 1; c1 <= colOne + 1; c1++) {
                for (int c2 = colTwo - 1; c2 <= colTwo + 1; c2++) {
                    max = Math.max(max, recurse(row + 1, c1, c2, grid, cache));
                } 
            }
            result += max;
        }
        return cache[row][colOne][colTwo] = result;
    }
}
