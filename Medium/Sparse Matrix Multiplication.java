class Solution {
  public int[][] multiply(int[][] mat1, int[][] mat2) {
    int[][] result = new int[mat1.length][mat2[0].length];
    for (int i = 0; i < mat1.length; i++) {
      for (int j = 0; j < mat1[0].length; j++) {
        if (mat1[i][j] != 0) {
          for (int k = 0; k < mat2[0].length; k++) {
            result[i][k] += mat1[i][j] * mat2[j][k];
          }
        }
      }
    }
    return result;
  }
}
