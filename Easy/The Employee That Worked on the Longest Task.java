class Solution {
  public int hardestWorker(int n, int[][] logs) {
    int maxTime = 0;
    int startTime = 0;
    int hardestWorkerId = 0;
    for (int[] log : logs) {
      int taskTime = log[1] - startTime;
      startTime = log[1];
      if (taskTime > maxTime) {
        maxTime = taskTime;
        hardestWorkerId = log[0];
      } else if (taskTime == maxTime) {
        if (hardestWorkerId > log[0]) {
          hardestWorkerId = log[0];
        }
      }
    }
    return hardestWorkerId;
  }
}
