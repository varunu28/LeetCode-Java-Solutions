class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> queue;
    int capacity;
    int sum = 0;
    public MovingAverage(int size) {
        capacity = size;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size() == capacity) {
            sum -= queue.remove();
        }

        queue.add(val);
        sum += val;

        double avg = (double) sum / queue.size();

        return avg;
    }
}
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
