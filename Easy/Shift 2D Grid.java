class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k %= m * n;
        while (k-- > 0) {
            int previous = grid[m - 1][n - 1];
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    int temp = grid[row][col];
                    grid[row][col] = previous;
                    previous = temp;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> resultRow = new ArrayList<>();
            for (int num : row) {
                resultRow.add(num);
            }
            result.add(resultRow);
        }
        return result;
    }
}
