class Solution {
  public int[] sortArrayByParity(int[] A) {
    int start = 0;
    int end = A.length - 1;
    while (start < end) {
      if (A[start] % 2 > A[end] % 2) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
      }
      if (A[start] % 2 == 0) {
        start++;
      }
      if (A[end] % 2 != 0) {
        end--;
      }
    }
    return A;
  }
}
