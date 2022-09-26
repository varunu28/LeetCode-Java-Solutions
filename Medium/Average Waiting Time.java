class Solution {
  public double averageWaitingTime(int[][] customers) {
    double totalWaitingTime = 0.0;
    int lastFreeTime = 0;
    for (int[] customer : customers) {
      int arrivalTime = customer[0];
      // Wait time before chef finishes previous task
      if (lastFreeTime > arrivalTime) {
        totalWaitingTime += lastFreeTime - arrivalTime;
      } else {
        lastFreeTime = arrivalTime;
      }
      // Wait time to finish task for current customer
      int taskTime = customer[1];
      totalWaitingTime += taskTime;
      lastFreeTime += taskTime;
    }
    return totalWaitingTime / customers.length;
  }
}
