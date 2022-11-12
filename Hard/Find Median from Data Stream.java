class MedianFinder {
    
    private final PriorityQueue<Integer> minQueue;
    private final PriorityQueue<Integer> maxQueue;
    
    public MedianFinder() {
        this.minQueue = new PriorityQueue<>();
        this.maxQueue = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        maxQueue.add(num);
        minQueue.add(maxQueue.poll());
        if (maxQueue.size() < minQueue.size()) {
            maxQueue.add(minQueue.poll());
        }
    }
    
    public double findMedian() {
        return maxQueue.size() > minQueue.size() ? 
            ((double) maxQueue.peek()) : 
            ((maxQueue.peek() + minQueue.peek()) / (2.0));
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
