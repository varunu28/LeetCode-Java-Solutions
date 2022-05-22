class Solution {
  public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < capacity.length; i++) {
      pq.add(capacity[i] - rocks[i]);
    }
    while (!pq.isEmpty()) {
      if (pq.peek() > additionalRocks) {
        return capacity.length - pq.size();
      }
      additionalRocks -= pq.poll();
    }
    return capacity.length;
  }
}
