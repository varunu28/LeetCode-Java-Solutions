class Solution {
    public int buyChoco(int[] prices, int money) {
        int cheapestChocolate = Math.min(prices[0], prices[1]);
        int secondCheapestChocolate = Math.max(prices[0], prices[1]);
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < cheapestChocolate) {
                secondCheapestChocolate = cheapestChocolate;
                cheapestChocolate = prices[i];
            } else if (prices[i] < secondCheapestChocolate) {
                secondCheapestChocolate = prices[i];
            }
        }
        int totalCost = cheapestChocolate + secondCheapestChocolate;
        return totalCost <= money ? (money - totalCost) : money;
    }
}
