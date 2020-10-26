class Solution {
  public double champagneTower(int poured, int query_row, int query_glass) {
    double[][] glassCapacity = new double[query_row + 1][query_glass + 2];
    glassCapacity[0][0] = poured;
    for (int currRow = 0; currRow < query_row; currRow++) {
      for (int currCol = 0; currCol <= query_glass; currCol++) {
        double currCapacity = Math.max(glassCapacity[currRow][currCol] - 1.0, 0);
        glassCapacity[currRow + 1][currCol] += currCapacity / 2.0;
        glassCapacity[currRow + 1][currCol + 1] += currCapacity / 2.0;
      }
    }
    return Math.min(glassCapacity[query_row][query_glass], 1.0);
  } 
}
