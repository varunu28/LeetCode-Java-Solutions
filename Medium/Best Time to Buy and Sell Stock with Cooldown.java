class Solution {
  int[] prices;
  Integer[] buyCache;
  Integer[] sellCache;
  public int maxProfit(int[] prices) {
    this.prices = prices;
    this.buyCache = new Integer[prices.length];
    this.sellCache = new Integer[prices.length];
    return buy(0);
  }
  
  private int buy(int idx) {
    if (idx >= prices.length) {
      return 0;
    }
    if (buyCache[idx] != null) {
      return buyCache[idx];
    }
    int cost = -prices[idx];
    int bestProfitBuying = sell(idx + 1) + cost;
    int bestProfitNotBuying = buy(idx + 1);
    buyCache[idx] = Math.max(bestProfitBuying, bestProfitNotBuying);
    return buyCache[idx];
  }
  
  private int sell(int idx) {
    if (idx == prices.length) {
      return 0;
    }
    if (sellCache[idx] != null) {
      return sellCache[idx];
    }
    int price = prices[idx];
    int bestProftSelling = buy(idx + 2) + price;
    int bestProfitNotSelling = sell(idx + 1);
    sellCache[idx] = Math.max(bestProftSelling, bestProfitNotSelling);
    return sellCache[idx];
  }
}
