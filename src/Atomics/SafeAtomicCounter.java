package Atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeAtomicCounter extends Thread {
    AtomicInteger count;

    public SafeAtomicCounter() {
        this.count = new AtomicInteger(0);
    }

    public void run() {
        int max = 100000000;
        for(int i = 0; i < max; i++) {
            this.count.addAndGet(1);
        }
    }
}
