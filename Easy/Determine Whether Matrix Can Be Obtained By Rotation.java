class Solution {
  public boolean findRotation(int[][] mat, int[][] target) {
    for (int i = 0; i < 4; i++) {
      if (isEqual(mat, target)) {
        return true;
      }
      rotate(mat);
    }
    return false;
  }

  private boolean isEqual(int[][] mat, int[][] target) {
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        if (mat[i][j] != target[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  private void rotate(int[][] mat){
    for(int i = 0; i < mat.length; i++){
      for(int j = i; j < mat[0].length; j++){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
      }
    }
    for(int i = 0; i < mat[0].length / 2; i++){
      for(int j = 0; j < mat.length; j++){
        int temp = mat[j][i];
        mat[j][i] = mat[j][mat[0].length - i - 1];
        mat[j][mat[0].length - i - 1] = temp;
      }
    }
  }
}
