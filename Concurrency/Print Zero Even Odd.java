class ZeroEvenOdd {
  private int n;
  private int flag = 0;

  public ZeroEvenOdd(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      while (flag != 0) {
        this.wait();
      }
      printNumber.accept(0);
      flag = i % 2 == 0 ? 1 : 2;
      this.notifyAll();
    }
  }

  public synchronized void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 2; i <= n; i += 2) {
      while (flag != 2) {
        this.wait();
      }
      printNumber.accept(i);
      flag = 0;
      this.notifyAll();
    }
  }

  public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i += 2) {
      while (flag != 1) {
        this.wait();
      }
      printNumber.accept(i);
      flag = 0;
      this.notifyAll();
    }
  }
}
