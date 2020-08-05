class MedianFinder {

  /** initialize your data structure here. */
  PriorityQueue<Integer> smaller;
  PriorityQueue<Integer> bigger;
  public MedianFinder() {
    smaller = new PriorityQueue<>((a, b) -> b - a);
    bigger = new PriorityQueue<>();
  }

  public void addNum(int num) {
    smaller.add(num);
    bigger.add(smaller.poll());
    if (smaller.size() < bigger.size()) {
        smaller.add(bigger.poll());
    }
  }

  public double findMedian() {
    if (smaller.size() == 0 && bigger.size() == 0) {
      return 0.0;
    }
    if (smaller.size() > bigger.size()) {
      return (double) smaller.peek();
    }
    return ((double) smaller.peek() + bigger.peek()) / 2;
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
