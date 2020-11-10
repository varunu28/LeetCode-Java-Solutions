class Solution {
  public int[][] flipAndInvertImage(int[][] A) {
    int numRows = A.length;
    int numCols = A[0].length - 1;
    for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
      int startIdx = 0;
      int endIdx = numCols;
      while (startIdx <= endIdx) {
        int temp = A[rowIdx][startIdx];
        A[rowIdx][startIdx++] = A[rowIdx][endIdx] == 1 ? 0 : 1;
        A[rowIdx][endIdx--] = temp == 1 ? 0 : 1;
      }
    }
    return A;
  }
}
