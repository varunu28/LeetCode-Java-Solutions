class Solution {
  public int[] sortedSquares(int[] A) {
    int posIdx = A.length;
    for (int i = 0; i < A.length; i++) {
      if (A[i] >= 0) {
        posIdx = i;
        break;
      }
    }
    int[] ans = new int[A.length];
    int negIdx = posIdx - 1;
    int idx = 0;
    while (negIdx >= 0 || posIdx < A.length) {
      if (negIdx >= 0 && (posIdx >= 0 && posIdx < A.length)) {
        if (A[negIdx] * A[negIdx] > A[posIdx] * A[posIdx]) {
          ans[idx++] = A[posIdx] * A[posIdx];
          posIdx++;
        }
        else {
          ans[idx++] = A[negIdx] * A[negIdx];
          negIdx--;
        }
      }
      else if (negIdx >= 0 && posIdx >= A.length) {
        ans[idx++] = A[negIdx] * A[negIdx];
        negIdx--;
      }
      else {
        ans[idx++] = A[posIdx] * A[posIdx];
        posIdx++;
      }
    }
    return ans;
  }
}
