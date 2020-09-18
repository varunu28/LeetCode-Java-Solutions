class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int currMin = Integer.MAX_VALUE;
    for (int price : prices) {
      if (price > currMin) {
        maxProfit = Math.max(maxProfit, price - currMin);
      }
      else {
        currMin = price;
      }
    }
    return maxProfit;
  }
}
