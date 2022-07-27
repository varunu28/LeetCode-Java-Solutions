class Solution {
  public int maxEvents(int[][] events) {
    Arrays.sort(events, (a, b) -> a[0] - b[0]);
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int idx = 0;
    int numOfEventsAttended = 0;
    int n = events.length;
    for (int currDay = 1; currDay <= 100000; currDay++) {
      while (!pq.isEmpty() && pq.peek() < currDay) {
        pq.poll();
      }
      while (idx < n && events[idx][0] == currDay) {
        pq.add(events[idx++][1]);
      }
      if (!pq.isEmpty()) {
        pq.poll();
        numOfEventsAttended++;
      }
    }
    return numOfEventsAttended;
  }
}
