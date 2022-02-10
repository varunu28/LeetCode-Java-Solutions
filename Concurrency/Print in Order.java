import java.util.concurrent.atomic.AtomicInteger;

class Foo {

  private Object lock;
  private AtomicInteger counter;

  public Foo() {
    this.lock = new Object();
    this.counter = new AtomicInteger(0);
  }

  public void first(Runnable printFirst) throws InterruptedException {

    // printFirst.run() outputs "first". Do not change or remove this line.
    synchronized (lock) {
      printFirst.run();
      this.counter.incrementAndGet();
      this.lock.notifyAll();
    }
  }

  public void second(Runnable printSecond) throws InterruptedException {
    // printSecond.run() outputs "second". Do not change or remove this line.
    synchronized (lock) {
      while (this.counter.get() != 1) {
        this.lock.wait();
      }
      printSecond.run();
      this.counter.incrementAndGet();
      this.lock.notifyAll();
    }
  }

  public void third(Runnable printThird) throws InterruptedException {
    // printThird.run() outputs "third". Do not change or remove this line.
    synchronized (lock) {
      while (this.counter.get() != 2) {
        this.lock.wait();
      }
      printThird.run();
    }
  }
}
