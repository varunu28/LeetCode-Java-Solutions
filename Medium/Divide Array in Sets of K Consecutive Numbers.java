class Solution {
  public boolean isPossibleDivide(int[] nums, int k) {
    if (nums.length % k != 0) {
      return false;
    }
    int n = nums.length;
    int numOfGroups = n / k;
    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    pq.addAll(map.keySet());
    while (!pq.isEmpty()) {
      int polled = pq.poll();
      if (map.get(polled) == 0) {
        continue;
      }
      int times = map.get(polled);
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
    return n == 0;
  }
}
