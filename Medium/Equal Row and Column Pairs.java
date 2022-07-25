class Solution {
  public int equalPairs(int[][] grid) {
    Map<String, Integer> map = new HashMap<>();
    int rows = grid.length;
    int cols = grid[0].length;
    for (int i = 0; i < rows; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < cols; j++) {
        sb.append(grid[i][j]).append("|");
      }
      String key = sb.toString();
      map.put(key, map.getOrDefault(key, 0) + 1);
    }
    int count = 0;
    for (int i = 0; i < cols; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < rows; j++) {
        sb.append(grid[j][i]).append("|");
      }
      String key = sb.toString();
      count += map.getOrDefault(key, 0);
    }
    return count;
  }
}
