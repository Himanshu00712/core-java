package Atomics;

public class SafeCounter extends Thread {
    int count = 0;
    public synchronized void run() {
        int max = 100000000;
        for(int i = 0; i < max; i++) {
            count++;
        }
    }
}
