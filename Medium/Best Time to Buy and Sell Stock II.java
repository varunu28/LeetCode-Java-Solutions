class Solution {
  public int maxProfit(int[] prices) {
    int stockBuyPrice = Integer.MAX_VALUE;
    int profit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] > stockBuyPrice) {
        profit += prices[i] - stockBuyPrice;
        stockBuyPrice = prices[i];
      } else {
        stockBuyPrice = prices[i];
      }
    }
    return profit;
  }
}
