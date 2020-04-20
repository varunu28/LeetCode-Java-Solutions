package LeetCodeAndOther;

import java.util.function.IntConsumer;

public class FizzBuzz {

    private final int n;
    private int curr;

    public FizzBuzz(int n) {
        this.n = n;
        curr = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(curr <= n) {
            if(curr % 3 == 0 && curr % 15 != 0) {
                printFizz.run();
                curr ++;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(curr <= n) {
            if(curr % 5 == 0 && curr % 15 != 0) {
                printBuzz.run();
                curr ++;
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(curr <= n) {
            if(curr % 15 == 0) {
                printFizzBuzz.run();
                curr ++;
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for( ; curr <= n; ) {
            if(curr % 3 != 0 && curr % 5 != 0) {
                printNumber.accept(curr);
                curr ++;
            }
        }
    }

}
