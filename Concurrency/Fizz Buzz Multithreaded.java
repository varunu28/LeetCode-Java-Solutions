class FizzBuzz {
    private int n;
    private final Semaphore fizzSemaphore;
    private final Semaphore buzzSemaphore;
    private final Semaphore fizzBuzzSemaphore;
    private final Semaphore numSemaphore;

    public FizzBuzz(int n) {
        this.n = n;
        this.fizzSemaphore = new Semaphore(0);
        this.buzzSemaphore = new Semaphore(0);
        this.fizzBuzzSemaphore = new Semaphore(0);
        this.numSemaphore = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizzSemaphore.acquire();
                printFizz.run();
                releaseLock(i + 1);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                buzzSemaphore.acquire();
                printBuzz.run();
                releaseLock(i + 1);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzSemaphore.acquire();
                printFizzBuzz.run();
                releaseLock(i + 1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                numSemaphore.acquire();
                printNumber.accept(i);
                releaseLock(i + 1);
            }
        }
    }
    
    private void releaseLock(int num) {
        if (num % 3 == 0 && num % 5 == 0) {
            fizzBuzzSemaphore.release();
        } else if (num % 3 == 0 && num % 5 != 0) {
            fizzSemaphore.release();
        } else if (num % 3 != 0 && num % 5 == 0) {
            buzzSemaphore.release();
        } else {
            numSemaphore.release();
        }
    }
}
