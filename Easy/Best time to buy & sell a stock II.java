class Solution {
  public int maxProfit(int[] prices) {
    int lowest = Integer.MAX_VALUE;
    int profit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] > lowest) {
        profit += prices[i] - lowest;
        lowest = prices[i];
      }
      else {
        lowest = prices[i];
      }
    }
    return profit;
  }
}
