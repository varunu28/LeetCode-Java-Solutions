class Solution {
  public int minDominoRotations(int[] A, int[] B) {
    int[] counterA = new int[7];
    int[] counterB = new int[7];
    int[] same = new int[7];
    int n = A.length;
    for (int i = 0; i < n; i++) {
      counterA[A[i]]++;
      counterB[B[i]]++;
      if (A[i] == B[i]) {
        same[A[i]]++;
      }
    }
    for (int i = 1; i < 7; i++) {
      if (counterA[i] + counterB[i] - same[i] == n) {
        return n - Math.max(counterA[i], counterB[i]);
      }
    }
    return -1;
  }
}
