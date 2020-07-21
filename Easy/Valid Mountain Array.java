class Solution {
  public boolean validMountainArray(int[] A) {
    if (A.length < 3) {
      return false;
    }
    int idx = 0;
    int n = A.length;
    while (idx + 1 < n && A[idx] < A[idx + 1]) {
      idx++;
    }
    if (idx == 0 || idx == n - 1) {
      return false;
    }
    while (idx + 1 < n && A[idx] > A[idx + 1]) {
      idx++;
    }
    return idx == n - 1;
  }
}
