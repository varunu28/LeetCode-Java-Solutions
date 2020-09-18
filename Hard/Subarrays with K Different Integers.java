class Solution {
  public int subarraysWithKDistinct(int[] A, int K) {
    return atMostK(A, K) - atMostK(A, K - 1);
  }
  
  private int atMostK(int[] A, int K) {
    int start = 0;
    int end = 0;
    int n = A.length;
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    while (end < n) {
      if (map.getOrDefault(A[end], 0) == 0) {
        K--;
      }
      map.put(A[end], map.getOrDefault(A[end], 0) + 1);
      while (K < 0) {
        map.put(A[start], map.getOrDefault(A[start], 0) - 1);
        if (map.get(A[start]) == 0) {
          K++;
        }
        start++;
      }
      count += end - start + 1;
      end++;
    }
    return count;
  }
}
