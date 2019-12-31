class Solution {
  public boolean isMonotonic(int[] A) {
    if (A.length <= 1) {
      return true;
    }
    int dir = 0;
    int idx = 0;
    while (idx < A.length - 1 && dir == 0) {
      dir = getDir(A, idx);
      idx++;
    }
    while (idx < A.length - 1) {
      int tempDir = getDir(A, idx);
      if (tempDir != 0 && tempDir != dir) {
        return false;
      }
      idx++;
    }
    return true;
  }
  
  private int getDir(int[] A, int idx) {
    return A[idx] < A[idx + 1] ? -1 : (A[idx] > A[idx + 1] ? 1 : 0);
  }
}
