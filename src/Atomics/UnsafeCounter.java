package Atomics;

public class UnsafeCounter extends Thread {
    int count = 0;
    public void run() {
        int max = 100000000;
        for(int i = 0; i < max; i++) {
            count++;
        }
    }
}
