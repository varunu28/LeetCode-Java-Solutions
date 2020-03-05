class Solution {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    for (int stone : stones) {
      pq.add(stone);
    }
    while(pq.size() > 1) {
      int y = pq.poll();
      int x = pq.poll();
      if (x != y) {
        pq.add(y - x);
      }
    }
    return pq.isEmpty() ? 0 : pq.poll();
  }
}
