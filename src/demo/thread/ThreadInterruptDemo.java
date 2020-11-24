package demo.thread;

public class ThreadInterruptDemo implements Runnable {
    @Override
    public void run() {
        boolean stop = false;
        while (!stop) {
            System.out.println("My thread is running");

            long time = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time) < 1000) {

            }

            if (Thread.currentThread().isInterrupted()) {
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadInterruptDemo(), "InterruptDemo thread");
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(3000);
        System.out.println(thread.getState());
        System.out.println("Interrupt thread");
        thread.interrupt();
        System.out.println("线程是否中断" + thread.isInterrupted());
        Thread.sleep(3000);
        System.out.println("Stopping application");
    }
}
