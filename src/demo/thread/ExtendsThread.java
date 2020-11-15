package demo.thread;

/**
 * 继承Thread
 */
public class ExtendsThread extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("这是线程A");
    }
}

class ThreadMainA {
    public static void main(String[] args) {
        ExtendsThread thread = new ExtendsThread();
        // 开启线程并不一定执行
        thread.start();
        System.out.println("这是主线程Main");
    }
}
