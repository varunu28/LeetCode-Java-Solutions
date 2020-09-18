class Solution {
  public List<Integer> luckyNumbers (int[][] matrix) {
    int numRows = matrix.length;
    int numCols = matrix[0].length;
    int[] rowMin = new int[numRows];
    int[] colMax = new int[numCols];
    Arrays.fill(rowMin, Integer.MAX_VALUE);
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        rowMin[i] = Math.min(matrix[i][j], rowMin[i]);
        colMax[j] = Math.max(matrix[i][j], colMax[j]);
      }
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (rowMin[i] == colMax[j]) {
          list.add(matrix[i][j]);
        }
      }
    }
    return list;
  }
}
