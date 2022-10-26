class Solution {
  public boolean haveConflict(String[] event1, String[] event2) {
    int minutesEvent1Start = getMinutes(event1[0]);
    int minutesEvent1End = getMinutes(event1[1]);
    int minutesEvent2Start = getMinutes(event2[0]);
    int minutesEvent2End = getMinutes(event2[1]);
    return !(minutesEvent1End < minutesEvent2Start || minutesEvent2End < minutesEvent1Start);
  }
  
  private static int getMinutes(String time) {
    String[] split = time.split(":");
    return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
  }
}
