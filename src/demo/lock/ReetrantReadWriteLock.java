package demo.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReetrantReadWriteLock {
    public static void main(String[] args) {
        final CountLock ct = new CountLock();
        for (int i=0; i < 2; i++) {
            new Thread(()-> ct.get()).start();
        }

        for (int i=0; i < 2; i++) {
            new Thread(()->ct.put()).start();
        }
    }
}


class CountLock {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void get() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "get begin");
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + "get end");
        } catch (Exception e) {
        } finally {
            lock.readLock().unlock();
        }
    }

    public void put() {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "put begin");
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + "put end");
        } catch (Exception e) {
        } finally {
            lock.writeLock().unlock();
        }
    }
}