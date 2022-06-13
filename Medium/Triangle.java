class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    Map<String, Integer> dp = new HashMap<>();
    return minimumTotalHelper(triangle, dp, 0, 0);
  }
  
  private int minimumTotalHelper(List<List<Integer>> triangle, Map<String, Integer> dp, int row, int col) {
    String key = row + "|" + col;
    if (dp.containsKey(key)) {
      return dp.get(key);
    }
    int path = triangle.get(row).get(col);
    if (row < triangle.size() - 1) {
      path += Math.min(minimumTotalHelper(triangle, dp, row + 1, col), minimumTotalHelper(triangle, dp, row + 1, col + 1));      
    }
    dp.put(key, path);
    return dp.get(key);
  }
}
