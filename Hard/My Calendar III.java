class MyCalendarThree {
  
  private TreeMap<Integer, Integer> delta;
  
  public MyCalendarThree() {
    this.delta = new TreeMap<>();
  }

  public int book(int start, int end) {
    delta.put(start, delta.getOrDefault(start, 0) + 1);
    delta.put(end, delta.getOrDefault(end, 0) - 1);
    int activeEvents = 0;
    int maxEvents = 0;
    for (int d : delta.values()) {
      activeEvents += d;
      maxEvents = Math.max(maxEvents, activeEvents);
    }
    return maxEvents;
  }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
