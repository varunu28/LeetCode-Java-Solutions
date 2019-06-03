class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> queue;
    int size;
    double total;
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        this.total = 0.0;
    }
    
    public double next(int val) {
        queue.add(val);
        this.total += val;
        
        if (queue.size() > this.size) {
            total -= queue.remove();
        }
        
        return total / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
