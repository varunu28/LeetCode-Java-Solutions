class Solution {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    if (timeSeries.length == 0 || duration <= 0) {
      return 0;
    }
    int totalTimePoisened = 0;
    int currPoisenedTime = 0;
    int n = timeSeries.length;
    for (int i = 0; i < n; i++) {
      if (currPoisenedTime > 0) {
        if (currPoisenedTime <= timeSeries[i]) {
          totalTimePoisened += duration;
        }
        else {
          totalTimePoisened += timeSeries[i] - timeSeries[i - 1];
        }
      }
      currPoisenedTime = timeSeries[i] + duration;
    }
    return totalTimePoisened + (currPoisenedTime - timeSeries[n - 1]);
  }
}
