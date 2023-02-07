class FooBar {
    private int n;
    
    private final Semaphore fooMutex;
    private final Semaphore barMutex;

    public FooBar(int n) {
        this.n = n;
        this.fooMutex = new Semaphore(1);
        this.barMutex = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            this.fooMutex.acquire();
        	printFoo.run();
            this.barMutex.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            this.barMutex.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            this.fooMutex.release();
        }
    }
}
