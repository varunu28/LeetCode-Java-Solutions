class Solution {
  public int subarraysDivByK(int[] A, int K) {
    int sum = 0;
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int i = 0; i < A.length; i++) {
      sum = (sum + A[i]) % K;
      if (sum < 0) {
        sum += K;
      }
      count += map.getOrDefault(sum, 0);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}
