package demo.thread;

/**
 * 实现Runnable接口
 */
public class ImplRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("这是线程B");
    }
}


class ThreadMainB {
    public static void main(String[] args) {
        ImplRunnable implRunnable = new ImplRunnable();
        new Thread(implRunnable).start();
        System.out.println("这是主线程Main");
    }
}
