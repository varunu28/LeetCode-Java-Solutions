class Solution {
  public boolean carPooling(int[][] trips, int capacity) {
    Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));
    int start = 0;
    int idx = 0;
    int n = trips.length;
    int currCapacity = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    while (idx < n) {
      while (!pq.isEmpty() && pq.peek()[2] <= trips[idx][1]) {
        currCapacity -= pq.poll()[0];
      }
      if (currCapacity + trips[idx][0] > capacity) {
        return false;
      }
      currCapacity += trips[idx][0];
      pq.add(trips[idx++]);
    }
    return true;
  }
}
