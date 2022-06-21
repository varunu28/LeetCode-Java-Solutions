class Solution {
  public int furthestBuilding(int[] heights, int bricks, int ladders) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 1; i < heights.length; i++) {
      int diff = heights[i] - heights[i - 1];
      if (diff > 0) {
        pq.add(diff);
        if (pq.size() > ladders) {
          bricks -= pq.poll();
        }
        if (bricks < 0) {
          return i - 1;
        }
      }
    }
    return heights.length - 1;
  }
}
