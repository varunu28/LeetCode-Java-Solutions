class Solution {
  public int numberOfArithmeticSlices(int[] A) {
    int counter = 0;
    int n = A.length;
    for (int i = 0; i < n - 2; i++) {
      int diff = A[i + 1] - A[i];
      int nextIdx = i + 2;
      while (nextIdx < n && A[nextIdx] - A[nextIdx - 1] == diff) {
        nextIdx++;
      }
      counter += nextIdx - i - 2;
    }
    return counter;
  }
}
