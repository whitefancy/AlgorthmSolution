package OJSolution.application.concurrent;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 每个线程都有一个 printNumber 方法来输出一个整数。
 * 请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 *
 * @author white
 * @version 1.0 2019-07-20
 */
class ZeroEvenOdd {
    private Semaphore same1 = new Semaphore(1);
    private Semaphore same2 = new Semaphore(0);
    private Semaphore same0 = new Semaphore(1);
    private int n;

    ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    void zero(IntConsumer printNumber) throws InterruptedException {
        for (Integer i = 0; i < n; i++) {
            same0.acquire(1);
            printNumber.accept(0);
            if (same1.availablePermits() == 1) {
                same1.release(1);
            }
            if (same2.availablePermits() == 1) {
                same2.release(1);
            }
        }
    }

    void even(IntConsumer printNumber) throws InterruptedException {
        for (Integer i = 1; i <= n; i += 2) {
            same1.acquire(2);
            printNumber.accept(i);
            same0.release(1);
            same2.release(1);
        }
    }

    void odd(IntConsumer printNumber) throws InterruptedException {
        for (Integer i = 2; i <= n; i += 2) {
            same2.acquire(2);
            printNumber.accept(i);
            same0.release(1);
            same1.release(1);
        }
    }
}
