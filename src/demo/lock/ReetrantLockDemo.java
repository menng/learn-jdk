package demo.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockDemo {
    public static void main(String[] args) {
        final Count ct = new Count();
        for(int i=0; i < 2; i++) {
            new Thread(() -> ct.get()).start();
        }

        for(int i=0; i < 2; i++) {
            new Thread(() -> ct.put()).start();
        }
    }
}

class Count {
    final ReentrantLock lock = new ReentrantLock();
    public void get() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "get begin");
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + "get end");
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void put() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "put begin");
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + "put end");
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
