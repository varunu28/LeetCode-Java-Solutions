class Solution {
  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    List<Task> tasks = new ArrayList<>();
    for (int i = 0; i < difficulty.length; i++) {
      tasks.add(new Task(profit[i], difficulty[i]));
    }
    tasks.sort(Comparator.comparingInt(o -> o.difficulty));
    Arrays.sort(worker);
    int idx = 0;
    int maxProfit = 0;
    int workerProfit = 0;
    for (int ability : worker) {
      while (idx < profit.length && ability >= tasks.get(idx).difficulty) {
        workerProfit = Math.max(workerProfit, tasks.get(idx++).profit);
      }
      maxProfit += workerProfit;
    }
    return maxProfit;
  }


  class Task {
    int profit;
    int difficulty;

    public Task(int profit, int difficulty) {
      this.profit = profit;
      this.difficulty = difficulty;
    }
  }
}
