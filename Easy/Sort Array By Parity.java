class Solution {
  public int[] sortArrayByParity(int[] A) {
    int evenIdx = 0;
    int oddIdx = A.length - 1;
    while (evenIdx < oddIdx) {
      if (A[evenIdx] % 2 == 0) {
        evenIdx++;
      } 
      else {
        int temp = A[evenIdx];
        A[evenIdx] = A[oddIdx];
        A[oddIdx--] = temp;
      }
    }
    return A;
  }
}
