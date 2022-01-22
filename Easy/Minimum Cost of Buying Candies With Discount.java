class Solution {
  public int minimumCost(int[] cost) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int price : cost) {
      pq.add(price);
    }
    int totalCost = 0;
    while (!pq.isEmpty()) {
      totalCost += pq.poll();
      if (!pq.isEmpty()) {
        totalCost += pq.poll();
      }
      if (!pq.isEmpty()) {
        pq.poll();
      }
    }
    return totalCost;
  }
}
