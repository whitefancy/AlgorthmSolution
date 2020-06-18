package OJSolution.application.concurrent;

import java.util.concurrent.CountDownLatch;

class Foo {
    private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch third = new CountDownLatch(1);

    Foo() {
    }

    void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
        second.countDown();
    }

    void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        second.await();
        printSecond.run();
        third.countDown();
    }

    void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        third.await();
        printThird.run();
    }
}
