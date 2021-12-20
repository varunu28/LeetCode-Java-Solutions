class Solution {
  public long getDescentPeriods(int[] prices) {
    long smoothDescentPeriods = 0;
    int idx = 0;
    while (idx < prices.length) {
      long currentDescentPeriod = 1;
      idx++;
      while (idx < prices.length && prices[idx - 1] - prices[idx] == 1) {
        currentDescentPeriod++;
        idx++;
      }
      smoothDescentPeriods += currentDescentPeriod * (currentDescentPeriod + 1) / 2;
    }
    return smoothDescentPeriods;
  }
}
