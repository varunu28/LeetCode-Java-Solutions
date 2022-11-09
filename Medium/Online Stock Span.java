class StockSpanner {
    
    // Entry in stack is the current price and count of prices <= current price
    private final Stack<int[]> stack;
    
    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            count += stack.pop()[1];
        }
        stack.push(new int[]{price, count});
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
