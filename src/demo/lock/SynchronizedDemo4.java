package demo.lock;

public class SynchronizedDemo4 {
    public void doSomething(){
        // 获取的是类锁，同synchronized修饰static方法。
        synchronized (SynchronizedDemo4.class) {
            System.out.println("doSomething 同步代码块，持有该对象的锁");
            try {
                // 睡5秒
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void doSomething2(){
        System.out.println("doSomething2 同步代码块，持有该对象的锁");
    }

    public static void main(String[] args) {
        SynchronizedDemo4 synchronizedDemo = new SynchronizedDemo4();

        new Thread(() -> synchronizedDemo.doSomething()).start();
        new Thread(() -> synchronizedDemo.doSomething2()).start();
        // 互不影响，一个获取的对象锁，一个获取的是类锁。
    }
}
