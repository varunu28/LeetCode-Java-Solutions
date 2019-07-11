class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int countOfIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numOfRows = grid.length;
        int numOfCols = grid[0].length;
        
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                }
                
                dfs(grid, i, j, numOfRows, numOfCols, visited);
                countOfIslands++;
            }
        }
        
        return countOfIslands;
    }
    
    private void dfs(char[][] grid, int x, int y, int numOfRows, int numOfCols, boolean[][] visited) {
        if (x < 0 || x >= numOfRows || y < 0 || y >= numOfCols || visited[x][y]) {
            return;
        }
        
        visited[x][y] = true;
        if (grid[x][y] == '0') {
            return;
        }
        
        for (int[] dir : dirs) {
            dfs(grid, x + dir[0], y + dir[1], numOfRows, numOfCols, visited);
        }
    }
}
