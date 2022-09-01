class Solution {
  public boolean carPooling(int[][] trips, int capacity) {
    Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    for (int[] trip : trips) {
      while (!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
        capacity += pq.poll()[0];
      }
      if (capacity < trip[0]) {
        return false;
      }
      pq.add(trip);
      capacity -= trip[0];
    }
    return true;
  }
}
