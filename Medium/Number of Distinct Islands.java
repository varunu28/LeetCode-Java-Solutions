class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> numOfIslands = new HashSet<>();
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder("f");
                    String island = dfsHelper(grid, i, j, sb);
                    numOfIslands.add(island);
                }
            }
        }
        
        return numOfIslands.size();
    }
    
    private String dfsHelper(int[][] grid, int row, int col, StringBuilder sb) {
        if (row == grid.length || row < 0 || col == grid[row].length || col < 0 || grid[row][col] == 0) {
            return sb.toString();
        }
        
        grid[row][col] = 0;
        
        sb.append(dfsHelper(grid, row - 1, col, new StringBuilder("u")));
        sb.append(dfsHelper(grid, row, col + 1, new StringBuilder("r")));
        sb.append(dfsHelper(grid, row + 1, col, new StringBuilder("d")));
        sb.append(dfsHelper(grid, row, col - 1, new StringBuilder("l")));
        
        return sb.toString();
    }
}
