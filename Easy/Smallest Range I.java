class Solution {
  public int smallestRangeI(int[] A, int K) {
    int maximum = A[0];
    int minimum = A[0];
    for (int num : A) {
      maximum = Math.max(num, maximum);
      minimum = Math.min(num, minimum);
    }
    return Math.max(0, maximum - minimum - 2 * K); 
  }
}
