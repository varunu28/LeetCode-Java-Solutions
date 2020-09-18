class Solution {
  public int twoSumLessThanK(int[] A, int K) {
    int maxSum = -1;
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < A.length; i++) {
      int diff = K - A[i];
      if (diff > 0) {
        Integer half = set.lower(diff);
        if (half != null) {
          maxSum = Math.max(maxSum, A[i] + half);
        }
      }
      set.add(A[i]);
    }
    return maxSum;
  }
}
