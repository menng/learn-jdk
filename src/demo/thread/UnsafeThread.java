package demo.thread;

public class UnsafeThread {
    public static void main(String[] args) {
        Count count = new Count();
        for (int i=0; i < 5; i++) {
            new Thread(() -> count.add()).start();
        }
        try {
            Thread.sleep(1001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最后的值: " + count.num);
    }
}


class Count {
    public int num = 0;
    public synchronized void add() {
        try {
            Thread.sleep(51);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num += 1;
        System.out.println(Thread.currentThread().getName() + ": " + num);
    }
}
