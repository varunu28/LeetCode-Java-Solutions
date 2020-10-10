class Solution {
  public int numSubmat(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int res = 0;
    for (int i = 0; i < m; i++) {
      int[] arr = new int[n];
      Arrays.fill(arr, 1);
      for (int j = i; j < m; j++) {
        for (int k = 0; k < n; k++) {
          arr[k] &= mat[j][k];
        }
        res += countOneRow(arr);
      }
    }
    return res;
  }
  
  private int countOneRow(int[] A) {
    int res = 0, length = 0;
    for (int i = 0; i < A.length; ++i) {
      length = (A[i] == 0 ? 0 : length + 1);
      res += length;
    }
    return res;
  }
}
