class MovingAverage {

  /** Initialize your data structure here. */
  Queue<Integer> queue;
  int size;
  double sum;
  public MovingAverage(int size) {
    sum = 0;
    this.size = size;
    queue = new LinkedList<>();
  }

  public double next(int val) {
    queue.add(val);
    sum += val;
    if (queue.size() > size) {
      sum -= queue.remove();
    }
    return sum / queue.size();
  }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
