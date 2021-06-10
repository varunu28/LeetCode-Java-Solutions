class MyCalendar {

  TreeMap<Integer, Integer> events;

  public MyCalendar() {
    events = new TreeMap<>();
  }

  public boolean book(int start, int end) {
    Integer lower = events.floorKey(start);
    Integer upper = events.ceilingKey(start);
    if ((lower == null || events.get(lower) <= start) && (upper == null || end <= upper)) {
      events.put(start, end);
      return true;
    }
    return false;
  }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
