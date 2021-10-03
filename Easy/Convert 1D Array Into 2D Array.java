class Solution {
  public int[][] construct2DArray(int[] original, int m, int n) {
    if (m * n != original.length) {
      return new int[][]{};
    }
    int[][] arr = new int[m][n];
    int idx = 0;
    int arrIdx = 0;
    while (idx < original.length) {
      for (int i = 0; i < n; i++) {
        arr[arrIdx][i] = original[idx++];
      }
      arrIdx++;
    }
    return arr;
  }
}
