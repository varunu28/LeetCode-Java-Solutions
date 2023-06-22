class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] notHolding = new int[n];
        int[] holding = new int[n];
        holding[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            holding[i] = Math.max(holding[i - 1], notHolding[i - 1] - prices[i]);
            notHolding[i] = Math.max(notHolding[i - 1], holding[i - 1] + prices[i] - fee);
        }
        return notHolding[n - 1];
    }
}
