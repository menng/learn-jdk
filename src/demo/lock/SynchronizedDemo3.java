package demo.lock;

/**
 *
 */
public class SynchronizedDemo3 {
    public void doSomething(){
        synchronized (SynchronizedDemo3.class) {
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
        synchronized (SynchronizedDemo3.class) {
            System.out.println("doSomething2 同步代码块，持有该对象的锁");
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo3 synchronizedDemo = new SynchronizedDemo3();
        SynchronizedDemo3 synchronizedDemo2 = new SynchronizedDemo3();

        new Thread(() -> synchronizedDemo.doSomething()).start();
        new Thread(() -> synchronizedDemo2.doSomething2()).start();
        // 预计doSomething执行完等5秒才会 执行doSomething2的同步代码块部分。
    }
}
