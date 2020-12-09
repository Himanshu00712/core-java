public class MyThreadRunnable implements Runnable{
    public void run() {
        System.out.println("Kartik's Thread...");
    }
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
    }
}
