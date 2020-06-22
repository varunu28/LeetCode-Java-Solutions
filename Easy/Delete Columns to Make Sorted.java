class Solution {
  public int minDeletionSize(String[] A) {
    int numRows = A.length;
    int numCols = A[0].length();
    int numDeletions = 0;
    for (int i = 0; i < numCols; i++) {
      for (int j = 1; j < numRows; j++) {
        if (A[j].charAt(i) < A[j - 1].charAt(i)) {
          numDeletions++;
          break;
        }
      }
    }
    return numDeletions;
  }
}
