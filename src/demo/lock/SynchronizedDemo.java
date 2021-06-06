package demo.lock;

/**
 * synchronized (this) 时，持有的对象的锁，会导致其他需要持有对象锁的同步方法无法获取对象锁而阻塞。
 */
public class SynchronizedDemo {
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
        synchronized (this) {
            System.out.println("doSomething2 同步代码块，持有该对象的锁");
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

        new Thread(() -> synchronizedDemo.doSomething()).start();
        new Thread(() -> synchronizedDemo.doSomething2()).start();
        // 预计doSomething执行完等5秒才会 执行doSomething2的同步代码块部分。
    }
}
