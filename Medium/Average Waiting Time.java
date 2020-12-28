class Solution {
  public double averageWaitingTime(int[][] customers) {
    long totalWaitingTime = 0;
    int currChefTime = 0;
    for (int[] customer : customers) {
      currChefTime = Math.max(currChefTime, customer[0]);
      int endTime = currChefTime + customer[1];
      totalWaitingTime += endTime - customer[0];
      currChefTime = endTime;
    }
    return totalWaitingTime / (double) customers.length;
  }
}
