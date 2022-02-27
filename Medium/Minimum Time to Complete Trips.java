class Solution {
  public long minimumTime(int[] time, int totalTrips) {
    long minTime = 1;
    long fastestBus = time[0];
    for (int t : time) {
      fastestBus = Math.min(fastestBus, t);
    }
    long maxTime = fastestBus * totalTrips;
    while (minTime < maxTime) {
      long midTime = minTime + (maxTime - minTime) / 2;
      if (getNumberOfTripsWithTime(time, midTime) >= totalTrips) {
        maxTime = midTime;
      } else {
        minTime = midTime + 1;
      }
    }
    return minTime;
  }
  
  private long getNumberOfTripsWithTime(int[] time, long currentTime) {
    long totalTrips = 0;
    for (int t : time) {
      totalTrips += currentTime / t;
    }
    return totalTrips;
  }
}
