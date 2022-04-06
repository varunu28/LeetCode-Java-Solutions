class H2O {
  private Semaphore hydrogen;
  private Semaphore oxygen;
  private Semaphore mutex;

  public H2O() {
    this.hydrogen = new Semaphore(2);
    this.oxygen = new Semaphore(0);
    this.mutex = new Semaphore(1);
  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    // releaseHydrogen.run() outputs "H". Do not change or remove this line.
    this.hydrogen.acquire();
    releaseHydrogen.run();
    this.oxygen.release();
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    this.mutex.acquire();
    this.oxygen.acquire(2);
    releaseOxygen.run();
    this.hydrogen.release(2);
    this.mutex.release();
  }
}
