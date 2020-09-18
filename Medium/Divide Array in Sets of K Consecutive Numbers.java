class Solution {
  public boolean isPossibleDivide(int[] nums, int k) {
    int n = nums.length;
    if (k == 0 || n < k || n % k != 0) {
      return false;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    pq.addAll(map.keySet());
    while (!pq.isEmpty()) {
      int polled = pq.poll();
      int times = map.get(polled);
      if (times != 0) {
        while (times-- > 0) {
          for (int i = 0; i < k; i++) {
            if (!map.containsKey(polled + i) || map.get(polled + i) == 0) {
              return false;
            }
            map.put(polled + i, map.get(polled + i) - 1);
          }
          n -= k;
        }
      }
    }
    return true;
  }
}
