package demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * CountDownLatch 等待一个或者多个线程执行完毕。
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception{
        int threadSize = 5;
        CountDownLatch cdl = new CountDownLatch(threadSize);
        for(int i=0; i< threadSize; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(1000));
                    System.out.println("finish" + index + Thread.currentThread().getName());
                    cdl.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // 主线程在阻塞，当计数器==0，就唤醒主线程往下执行。
        cdl.await();

        System.out.println("主线程继续执行");
    }
}
