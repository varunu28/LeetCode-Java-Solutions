class Solution {
  public boolean checkStraightLine(int[][] coordinates) {
    int xOne = coordinates[1][0]; 
    int yOne = coordinates[1][1];
    int dx = xOne - coordinates[0][0];
    int dy = yOne - coordinates[0][1];
    for (int[] coordinate : coordinates) {
      int x = coordinate[0];
      int y = coordinate[1];
      if (dx * (y - yOne) != dy * (x - xOne)) {
        return false;
      }
    }
    return true;
  }
}
