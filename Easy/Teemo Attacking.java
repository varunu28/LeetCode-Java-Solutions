class Solution {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int totalDuration = 0;
    int prevTime = timeSeries[0];
    for (int i = 1; i < timeSeries.length; i++) {
      totalDuration += Math.min(duration, timeSeries[i] - prevTime);
      prevTime = timeSeries[i];
    }
    return totalDuration + duration;
  }
}
