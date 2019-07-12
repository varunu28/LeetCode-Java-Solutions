class Foo {
    
    private int counter = 1;
    private String mutex = "";
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        boolean flag = true;
        while (flag) {
            synchronized(mutex) {
                if (counter == 1) {
                    printFirst.run();
                    counter++;
                    flag = false;
                }
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        boolean flag = true;
        while (flag) {
            synchronized(mutex) {
                if (counter == 2) {
                    printSecond.run();
                    counter++;
                    flag = false;
                }
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        boolean flag = true;
        while (flag) {
            synchronized(mutex) {
                if (counter == 3) {
                    printThird.run();
                    counter++;
                    flag = false;
                }
            }
        }
    }
}
