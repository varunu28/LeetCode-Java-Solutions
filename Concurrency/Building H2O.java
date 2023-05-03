class H2O {
    
    private Semaphore hydrogenSemaphore;
    private Semaphore oxygenSemaphore;

    public H2O() {
        this.hydrogenSemaphore = new Semaphore(2);
        this.oxygenSemaphore = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hydrogenSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        this.oxygenSemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        this.oxygenSemaphore.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        this.hydrogenSemaphore.release(2);
    }
}
