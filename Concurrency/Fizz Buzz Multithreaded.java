class FizzBuzz {
  private int n;
  private int count;
  private Semaphore fizz;
  private Semaphore buzz;
  private Semaphore fizzBuzz;
  private Semaphore number;

  public FizzBuzz(int n) {
    this.n = n;
    this.count = 1;
    this.fizz = new Semaphore(0);
    this.buzz = new Semaphore(0);
    this.fizzBuzz = new Semaphore(0);
    this.number = new Semaphore(1);
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    while (this.count <= this.n) {
      if (this.count % 3 == 0 && this.count % 5 != 0) {
        this.fizz.acquire();
        printFizz.run();
        this.count++;
        releaseLock(this.count);
      }
    }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    while (this.count <= this.n) {
      if (this.count % 3 != 0 && this.count % 5 == 0) {
        this.buzz.acquire();
        printBuzz.run();
        this.count++;
        releaseLock(this.count);
      }
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    while (this.count <= this.n) {
      if (this.count % 3 == 0 && this.count % 5 == 0) {
        this.fizzBuzz.acquire();
        printFizzBuzz.run();
        this.count++;
        releaseLock(this.count);
      }
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    while (this.count <= this.n) {
      if (this.count % 3 != 0 && this.count % 5 != 0) {
        this.number.acquire();
        printNumber.accept(this.count);
        this.count++;
        releaseLock(this.count);
      }
    }
  }
  
  private void releaseLock(int n) {
    if (n % 15 == 0) {
      this.fizzBuzz.release();
    } else if (n % 3 == 0) {
      this.fizz.release();
    } else if (n % 5 == 0) {
      this.buzz.release();
    } else {
      this.number.release();
    }
  }
}
