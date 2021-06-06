package demo.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    private static int count = 0;
    private static AtomicInteger countAtomic = new AtomicInteger(0);

    public static void main(String[] args) throws Exception{
        System.out.println(String.format("%06d", 99999999L));
        addInt();
        addAtomicInteger();
    }

    public static void addAtomicInteger() throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for(int i=0; i< 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    countAtomic.incrementAndGet();
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();

        System.out.println(countAtomic.get());
    }

    public static void addInt() throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for(int i=0; i< 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    count++;
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();

        System.out.println(count);
    }
}
