class RecentCounter {
  Queue<Integer> queue;
  int limit;
  public RecentCounter() {
    queue = new LinkedList<>();
    limit = 3000;
  }

  public int ping(int t) {
    queue.add(t);
    while (!queue.isEmpty() && ((t - queue.peek()) > limit)) {
      queue.remove();
    }
    return queue.size();
  }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
