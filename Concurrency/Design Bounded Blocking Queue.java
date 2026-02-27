class BoundedBlockingQueue {

    private final Queue<Integer> queue;
    private final int capacity;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                full.await();
            }
            queue.add(element);
            empty.signal();
        } finally {
            lock.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
        lock.lock(); 
        try {
            while (queue.isEmpty()) {
                empty.await();
            } 
            int result = queue.remove();
            full.signal();
            return result;
        } finally {
            lock.unlock();
        }
    }
    
    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }
}
