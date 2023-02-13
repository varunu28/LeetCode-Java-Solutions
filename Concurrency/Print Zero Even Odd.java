class ZeroEvenOdd {
    private int n;
    
    private final Semaphore zeroMutex;
    private final Semaphore oddMutex;
    private final Semaphore evenMutex;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zeroMutex = new Semaphore(1);
        this.oddMutex = new Semaphore(0);
        this.evenMutex = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            this.zeroMutex.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                this.oddMutex.release();
            } else {
                this.evenMutex.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            this.evenMutex.acquire();
            printNumber.accept(i);
            this.zeroMutex.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            this.oddMutex.acquire();
            printNumber.accept(i);
            this.zeroMutex.release();
        } 
    }
}
