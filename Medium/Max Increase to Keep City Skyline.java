class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
      int numRows = grid.length;
      int numCols = grid[0].length;
      int[] rowMax = new int[numRows];
      int[] colMax = new int[numCols];
      for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numCols; j++) {
          rowMax[i] = Math.max(rowMax[i], grid[i][j]);
          colMax[j] = Math.max(colMax[j], grid[i][j]);
        }
      }    
      int totalIncrease = 0;
      for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numCols; j++) {
          totalIncrease += Math.min(rowMax[i], colMax[j]) - grid[i][j];
        }
      }
      return totalIncrease;
    }
}
