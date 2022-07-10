class Solution {
  public int fillCups(int[] amount) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    for (int count : amount) {
      updateQueue(pq, count);
    }
    int totalTime = 0;
    while (!pq.isEmpty()) {
      int removedOne = pq.poll();
      int removedTwo = pq.isEmpty() ? 0 : pq.poll();
      removedOne--;
      removedTwo--;
      updateQueue(pq, removedOne);
      updateQueue(pq, removedTwo);
      totalTime++;
    }
    return totalTime;
  }
  
  private void updateQueue(PriorityQueue<Integer> pq, int count) {
    if (count > 0) {
      pq.add(count);
    }
  }
}
