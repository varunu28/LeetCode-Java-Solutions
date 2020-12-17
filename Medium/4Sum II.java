class Solution {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    int n = A.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
      }
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        count += map.getOrDefault(-1 * (C[i] + D[j]), 0);
      }
    }
    return count;
  }
}
