class Solution {
  public int connectSticks(int[] sticks) {
    int cost = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int stick : sticks) {
      pq.add(stick);
    }
    while (pq.size() > 1) {
      int first = pq.poll();
      int second = pq.poll();
      int joinSum = first + second;
      cost += joinSum;
      pq.add(joinSum);
    }
    return cost;
  }
}
