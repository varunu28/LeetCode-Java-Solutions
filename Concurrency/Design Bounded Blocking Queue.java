class BoundedBlockingQueue {
  
  private final Queue<Integer> queue;
  private final Semaphore mutex;
  private final Semaphore items;
  private final Semaphore capacityTracker;
  private int currentCapacity;

  public BoundedBlockingQueue(int capacity) {
    this.queue = new LinkedList<>();
    this.mutex = new Semaphore(1);
    this.items = new Semaphore(0);
    this.capacityTracker = new Semaphore(capacity);
    this.currentCapacity = 0;
  }

  public void enqueue(int element) throws InterruptedException {
    this.capacityTracker.acquire();
    this.mutex.acquire();
    this.queue.add(element);
    this.currentCapacity++;
    this.mutex.release();
    this.items.release();
  }

  public int dequeue() throws InterruptedException {
    this.items.acquire();
    this.mutex.acquire();
    int result = this.queue.remove();
    this.currentCapacity--;
    this.mutex.release();
    this.capacityTracker.release();
    return result;
  }

  public int size() throws InterruptedException {
    this.mutex.acquire();
    int currentSize = this.currentCapacity;
    this.mutex.release();
    return currentSize;
  }
}
