package Atomics;

public class Main {
    public static void runUnSafeCounter() throws InterruptedException {
        /* UnSafe Counter*/
        UnsafeCounter c = new UnsafeCounter();
        Thread first = new Thread(c, "First");
        Thread second = new Thread(c, "Second");
        first.start();
        second.start();
        // main thread will wait for
        // both threads to get completed
        first.join();
        second.join();
        System.out.println(c.count); // will be random inconsistent output as it isn't thread safe
    }

    public static void runSafeCounter() throws InterruptedException {
        SafeCounter sc = new SafeCounter();
        Thread first1 = new Thread(sc, "first1");
        Thread second1 = new Thread(sc, "second2");
        first1.run();
        second1.run();

        first1.join();
        second1.join();
        System.out.println(sc.count); // This got solved via synchronized blocks which select only one thread out of others to pass through at a time.
    }

    public static void runAtomicSafeCounter() throws InterruptedException {
        SafeAtomicCounter c = new SafeAtomicCounter();
        Thread first = new Thread(c, "first");
        Thread second = new Thread(c, "second");
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println(c.count);
    }
    public static void main(String[] args) throws InterruptedException {
        runUnSafeCounter();
        runSafeCounter();
        runAtomicSafeCounter();
    }
}
