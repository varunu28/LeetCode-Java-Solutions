class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        double result = 0;
        int priceIdx = prices.length - 1;
        int discountIdx = discounts.length - 1;
        while (priceIdx >= 0) {
            double currPrice = prices[priceIdx--];
            if (discountIdx >= 0) {
                double currDiscount = discounts[discountIdx--];
                currPrice = (currPrice * (100 - currDiscount)) / 100;
            }
            result += currPrice;
        }
        return result;
    }
}
