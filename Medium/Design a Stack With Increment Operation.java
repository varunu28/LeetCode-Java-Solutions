class CustomStack {

    private final int maxSize;
    private final Stack<Integer> stack;
    private int[] increment;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Stack<>();
        this.increment = new int[maxSize];
    }
    
    public void push(int x) {
        if (stack.size() < maxSize) {
            stack.push(x);
        }
    }
    
    public int pop() {
        int idx = stack.size() - 1;
        if (idx < 0) {
            return -1;
        }
        if (idx > 0) {
            increment[idx - 1] += increment[idx];
        }
        int result = stack.pop() + increment[idx];
        increment[idx] = 0;
        return result;
    }
    
    public void increment(int k, int val) {
        int idx = Math.min(k, stack.size()) - 1;
        if (idx >= 0) {
            increment[idx] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
