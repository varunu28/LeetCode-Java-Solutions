class Solution {
  public int smallestCommonElement(int[][] mat) {
    Map<Integer, Integer> map = new HashMap<>();
    int numRows = mat.length;
    int numCols = mat[0].length;
    for (int i = 0; i < numCols; i++) {
      for (int j = 0; j < numRows; j++) {
        map.put(mat[j][i], map.getOrDefault(mat[j][i], 0) + 1);
        if (map.get(mat[j][i]) == numRows) {
          return mat[j][i];
        }
      }
    }
    return -1;
  }
}
