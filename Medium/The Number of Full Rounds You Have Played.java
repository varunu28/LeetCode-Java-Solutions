class Solution {
  public int numberOfRounds(String startTime, String finishTime) {
    int startMinutes = toMinutes(startTime);
    int finishMinutes = toMinutes(finishTime);
    int roundedStart = toNextQuarter(startMinutes);
    int roundedFinish = toPreviousQuarter(finishMinutes);
    if (startMinutes < finishMinutes) {
      return Math.max(0, (roundedFinish - roundedStart) / 15);
    }
    return (24 * 60 - roundedStart + roundedFinish) / 15;
  }

  public static int toMinutes(String s) {
    return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
  }

  public static int toNextQuarter(int time) {
    return ((time + 14) / 15) * 15;
  }

  public static int toPreviousQuarter(int time) {
    return (time / 15) * 15;
  }
}
