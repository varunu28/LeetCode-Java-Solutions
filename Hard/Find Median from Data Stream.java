class MedianFinder {

  private PriorityQueue<Integer> small;
  private PriorityQueue<Integer> large;
  
  public MedianFinder() {
    this.small = new PriorityQueue<>((a, b) -> b - a);
    this.large = new PriorityQueue<>();
  }

  public void addNum(int num) {
    small.add(num);
    large.add(small.remove());
    if (large.size() > small.size()) {
      small.add(large.remove());
    }
  }

  public double findMedian() {
    if (small.size() > large.size()) {
      return small.peek();
    }
    return (small.peek() + large.peek()) / 2.0;
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
