class MyCalendarTwo {
  
  private TreeMap<Integer, Integer> delta;
  
  public MyCalendarTwo() {
    this.delta = new TreeMap<>();
  }

  public boolean book(int start, int end) {
    delta.put(start, delta.getOrDefault(start, 0) + 1);
    delta.put(end, delta.getOrDefault(end, 0) - 1);
    int active = 0;
    for (int d : delta.values()) {
      active += d;
      if (active >= 3) {
        delta.put(start, delta.get(start) - 1);
        delta.put(end, delta.get(end) + 1);
        return false;
      }
    }
    return true;
  }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
