class MyCircularQueue {
  private int[] queue;
  private int valueCursor;
  private int emptyCursor;

  public MyCircularQueue(int k) {
    this.queue = new int[k];
    Arrays.fill(queue, -1);
    this.emptyCursor = 0;
    this.valueCursor = 0;
  }

  public boolean enQueue(int value) {
    if (this.queue[this.emptyCursor] != -1) {
      return false;
    }
    this.queue[this.emptyCursor++] = value;
    if (this.emptyCursor == this.queue.length) {
      this.emptyCursor = 0;
    }
    return true;
  }

  public boolean deQueue() {
    if (this.queue[this.valueCursor] == -1) {
      return false;
    }
    this.queue[this.valueCursor++] = -1;
    if (this.valueCursor == this.queue.length) {
      this.valueCursor = 0;
    }
    return true;
  }

  public int Front() {
    return this.queue[this.valueCursor];
  }

  public int Rear() {
    int idx = this.emptyCursor == 0 ? this.queue.length - 1 : this.emptyCursor - 1;
    return this.queue[idx];
  }

  public boolean isEmpty() {
    return this.queue[this.valueCursor] == -1;
  }

  public boolean isFull() {
    return this.queue[this.emptyCursor] != -1;
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
