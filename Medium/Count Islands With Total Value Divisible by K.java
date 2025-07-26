class Solution {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;  
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    int[] value = {0};
                    traverse(grid, i, j, visited, value);
                    if (value[0] % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void traverse(int[][] grid, int row, int col, boolean[][] visited, int[] value) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            return;
        }
        visited[row][col] = true;
        value[0] += grid[row][col];
        for (int[] dir : DIRECTIONS) {
            traverse(grid, row + dir[0], col + dir[1], visited, value);
        }
    }
}
