class Solution {
  public boolean checkValid(int[][] matrix) {
    Map<Integer, Set<Integer>> rowMap = new HashMap<>();
    Map<Integer, Set<Integer>> colMap = new HashMap<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        rowMap.computeIfAbsent(i, k -> new HashSet<>()).add(matrix[i][j]);
        colMap.computeIfAbsent(j, k -> new HashSet<>()).add(matrix[i][j]);
      }
    }
    return rowMap.values().stream().allMatch(e -> e.size() == matrix.length) && 
        colMap.values().stream().allMatch(e -> e.size() == matrix.length);
  }
}
