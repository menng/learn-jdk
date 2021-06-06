package demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * CountDownLatch 等待一个或者多个线程执行完毕。
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws Exception{
        CountDownLatch cdl = new CountDownLatch(1);
        for(int i=0; i< 5; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    cdl.await();
                    Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(1000));
                    System.out.println("finish" + index + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        cdl.countDown();

        System.out.println("主线程继续执行");
    }
}
