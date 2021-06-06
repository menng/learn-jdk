package demo.lock;

/**
 * 持有非this对象锁，不会影响其他同步代码块获取锁。
 */
public class SynchronizedDemo2 {
    private Object lock = new Object();
    public void doSomething(){
        synchronized (this) {
            System.out.println("doSomething 同步代码块，持有该对象的锁");
            try {
                // 睡5秒
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doSomething2(){
        // 不会被持有该对象锁的 doSomething 同步代码块 影响。
        synchronized (lock) {
            System.out.println("doSomething2 同步代码块，持有该对象的锁");
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo2 synchronizedDemo = new SynchronizedDemo2();

        new Thread(() -> synchronizedDemo.doSomething()).start();
        new Thread(() -> synchronizedDemo.doSomething2()).start();
    }
}
