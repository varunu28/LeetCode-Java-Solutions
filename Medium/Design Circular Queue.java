class MyCircularQueue {
  
  private Integer[] queue;
  private int valueCursor;
  private int emptyCursor;

  public MyCircularQueue(int k) {
    this.queue = new Integer[k];
    this.valueCursor = 0;
    this.emptyCursor = 0;
  }

  public boolean enQueue(int value) {
    if (queue[emptyCursor] != null) {
      return false;
    }
    queue[emptyCursor++] = value;
    if (emptyCursor == queue.length) {
      emptyCursor = 0;
    }
    return true;
  }

  public boolean deQueue() {
    if (queue[valueCursor] == null) {
      return false;
    }
    queue[valueCursor++] = null;
    if (valueCursor == queue.length) {
      valueCursor = 0;
    }
    return true;
  }

  public int Front() {
    return queue[valueCursor] == null ? -1 : queue[valueCursor];
  }

  public int Rear() {
    int idx = emptyCursor == 0 ? queue.length - 1 : emptyCursor - 1;
    return queue[idx] == null ? -1 : queue[idx];
  }

  public boolean isEmpty() {
    return queue[valueCursor] == null;
  }

  public boolean isFull() {
    return queue[emptyCursor] != null;
  }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
