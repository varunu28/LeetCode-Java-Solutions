class Solution {
  public int[] sortArrayByParityII(int[] A) {
    int start = 1;
    for (int i = 0; i < A.length; i += 2) {
      if (A[i] % 2 == 1) {
        while (A[start] % 2 != 0) {
          start += 2;
        }
        int temp = A[i];
        A[i] = A[start];
        A[start] = temp;
      }
    }
    return A;
  }
}
