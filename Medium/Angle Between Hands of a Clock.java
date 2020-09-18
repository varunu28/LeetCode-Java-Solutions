class Solution {
  public double angleClock(int hour, int minutes) {
    double angleByHourHand = (hour % 12 + minutes / 60.0) * 30;
    double angleByMinuteHand = (double) 6 * minutes;
    double diff = Math.abs(angleByHourHand - angleByMinuteHand);
    return Math.min(diff, 360 - diff);
  }
}
