class Solution {
  private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  
  public int closedIsland(int[][] grid) {
    int numberOfClosedIslands = 0;
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++){
        if(grid[i][j] == 0){
          if(surroundsSuccessfully(grid, i, j)) {
            numberOfClosedIslands++;
          }
        }
      }
    }
    return numberOfClosedIslands;
  }

  private boolean surroundsSuccessfully(int[][] grid, int x, int y) {
    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
      return false;
    }
    if(grid[x][y] == 1) {
      return true;
    }
    grid[x][y] = 1;
    boolean result = true;
    for(int[] dir : DIRS){
      result = result & surroundsSuccessfully(grid, x + dir[0], y + dir[1]);
    }
    return result;
  }
}
