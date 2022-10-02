class Solution {
  
  private static final int[][] coordinates = {{0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 0}, {2, 1}, {2, 2}}; 
  
  public int maxSum(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int highestHourglassSum = 0;
    for (int i = 0; i < rows - 2; i++) {
      for (int j = 0; j < cols - 2; j++) {
        int currSum = 0;
        for (int[] coordinate : coordinates) {
          int x = i + coordinate[0];
          int y = j + coordinate[1];
          currSum += grid[x][y];
        }
        highestHourglassSum = Math.max(highestHourglassSum, currSum);
      }
    }
    return highestHourglassSum;
  }
}
