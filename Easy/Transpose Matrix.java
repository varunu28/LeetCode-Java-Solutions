class Solution {
  public int[][] transpose(int[][] A) {
    if (A.length == 0 || A[0].length == 0) {
      return A;
    }
    int[][] ans = new int[A[0].length][A.length];
    for (int i = 0; i < A[0].length; i++) {
      for (int j = 0; j < A.length; j++) {
        ans[i][j] = A[j][i];
      }
    }
    return ans;
  }
}
