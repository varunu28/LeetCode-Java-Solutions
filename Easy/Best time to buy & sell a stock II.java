class Solution {
    public int maxProfit(int[] prices) {
        int currMin = Integer.MAX_VALUE;
        int profit = 0;
        
        for (int price : prices) {
            if (price > currMin) {
                profit += price - currMin;
            }        
            
            currMin = price;
        }
        
        return profit;
    }
}
