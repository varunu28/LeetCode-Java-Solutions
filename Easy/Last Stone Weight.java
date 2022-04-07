class Solution {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int stone : stones) {
      pq.add(stone);
    }
    while (pq.size() > 1) {
      int firstStone = pq.poll();
      int secondStone = pq.poll();
      if (firstStone != secondStone) {
        pq.add(firstStone - secondStone);
      }
    }
    return pq.isEmpty() ? 0 : pq.poll();
  }
}
