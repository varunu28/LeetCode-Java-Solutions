class Solution {
  public int[] frequencySort(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
      int c = map.get(o1).compareTo(map.get(o2));
      if (c != 0) {
        return c;
      }
      return o2.compareTo(o1);
    });
    pq.addAll(map.keySet());
    int idx = 0;
    while (!pq.isEmpty()) {
      int removed = pq.remove();
      for (int i = 0; i < map.get(removed); i++) {
        nums[idx++] = removed;
      }
    }
    return nums;
  }
}
