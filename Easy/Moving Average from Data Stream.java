class MovingAverage {

    private final Queue<Integer> queue;
    private double currSum;
    private final int size;
    
    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.currSum = 0;
        this.size = size;
    }
    
    public double next(int val) {
        this.queue.add(val);
        this.currSum += val;
        if (this.queue.size() > this.size) {
            this.currSum -= this.queue.remove();
        }
        return this.currSum / this.queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
