class Solution {
  private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int orangesRotting(int[][] grid) {
    Queue<int[]> infectedOranges = new LinkedList<>();
    int numOfFreshOranges = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 2) {
          infectedOranges.add(new int[]{i, j});
        }
        numOfFreshOranges += grid[i][j] == 1 ? 1 : 0;
      }
    }
    int numOfMinutes = 0;
    while (!infectedOranges.isEmpty()) {
      int infectedOrangeSize = infectedOranges.size();
      boolean newInfected = false;
      while (infectedOrangeSize-- > 0) {
        int[] infectedOrangeCoordinate = infectedOranges.poll();
        for (int[] dir : DIRS) {
          int newRowCoordinate = infectedOrangeCoordinate[0] + dir[0];
          int newColCoordinate = infectedOrangeCoordinate[1] + dir[1];
          if (isValidInfection(grid, newRowCoordinate, newColCoordinate)) {
            infectedOranges.add(new int[]{newRowCoordinate, newColCoordinate});
            grid[newRowCoordinate][newColCoordinate] = 2;
            newInfected = true;
            numOfFreshOranges--;
          }
        }
      }
      numOfMinutes += newInfected ? 1 : 0;
    }
    return numOfFreshOranges > 0 ? -1 : numOfMinutes;
  }

  private boolean isValidInfection(int[][] grid, int rowCoordinate, int colCoordinate) {
    return rowCoordinate >= 0 && colCoordinate >= 0 && rowCoordinate < grid.length
        && colCoordinate < grid[0].length && grid[rowCoordinate][colCoordinate] == 1;
  }
}
