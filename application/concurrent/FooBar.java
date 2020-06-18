package OJSolution.application.concurrent;

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore semaphore1;
    private Semaphore semaphore2;

    FooBar(int n) {
        this.n = n;
        semaphore1 = new Semaphore(1);
        semaphore2 = new Semaphore(0);
    }

    void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            semaphore1.acquire(1);
            printFoo.run();
            semaphore2.release(1);
        }
    }

    void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            semaphore2.acquire(1);
            printBar.run();
            semaphore1.release(1);
        }
    }
}
