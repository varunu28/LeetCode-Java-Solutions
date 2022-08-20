class Solution {
  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int result = 0;
    int prev = 0;
    for (int[] station : stations) {
      int location = station[0];
      int capacity = station[1];
      startFuel -= location - prev;
      while (!pq.isEmpty() && startFuel < 0) {
        startFuel += pq.poll();
        result++;
      }
      if (startFuel < 0) {
        return -1;
      }
      pq.add(capacity);
      prev = location;
    }
    startFuel -= target - prev;
    while (!pq.isEmpty() && startFuel < 0) {
      startFuel += pq.poll();
      result++;
    }
    return startFuel < 0 ? -1 : result;
  }
}
