class Solution {
  public boolean carPooling(int[][] trips, int capacity) {
    Arrays.sort(trips, Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt(o -> o[2]));
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
    int idx = 0;
    while (idx < trips.length) {
      while (!priorityQueue.isEmpty() && priorityQueue.peek()[2] <= trips[idx][1]) {
        capacity += priorityQueue.poll()[0];
      }
      if (capacity < trips[idx][0]) {
        return false;
      }
      priorityQueue.add(trips[idx]);
      capacity -= trips[idx++][0];
    }
    return true;
  }
}
