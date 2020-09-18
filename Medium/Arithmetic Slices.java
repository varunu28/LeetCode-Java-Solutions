class Solution {
  public int numberOfArithmeticSlices(int[] A) {
    int count = 0;
    for (int i = 0; i < A.length - 2; i++) {
      int diff = A[i + 1] - A[i];
      for (int j = i + 2; j < A.length; j++) {
        if (A[j] - A[j - 1] == diff) {
          count++;
        }
        else {
          break;
        }
      }
    }
    return count;
  }
}
