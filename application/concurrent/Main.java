package OJSolution.application.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

public class Main {
    private static ExecutorService exec;

    public static void main(String[] args) throws InterruptedException {
        Main.exec = Executors.newCachedThreadPool();
        Main.testZero();
        Main.exec.shutdown();
    }

    private static void testFoo() {
        Foo f = new Foo();
        Main.exec.execute(() -> {
            try {
                f.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Main.exec.execute(() -> {
            try {
                f.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Main.exec.execute(() -> {
            try {
                f.first(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("first");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void testFooBar() {
        FooBar fooBar = new FooBar(3);

        Main.exec.execute(() -> {
            try {
                fooBar.foo(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("foo");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Main.exec.execute(() -> {
            try {
                fooBar.bar(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("bar");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void testZero() {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        Main.exec.execute(() -> {
            try {
                zeroEvenOdd.odd(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.print(value);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Main.exec.execute(() -> {
            try {
                zeroEvenOdd.zero(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.print(value);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Main.exec.execute(() -> {
            try {
                zeroEvenOdd.even(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.print(value);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
