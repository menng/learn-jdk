package demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo2  implements Runnable{
    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(nextId::getAndIncrement);

    public static Integer get() {
        return threadId.get();
    }


    public static void main(String[] args) {
        new Thread(new ThreadLocalDemo2()).start();
//        new Thread(new ThreadLocalDemo2()).start();
//        new Thread(new ThreadLocalDemo2()).start();
//        new Thread(new ThreadLocalDemo2()).start();
//        new Thread(new ThreadLocalDemo2()).start();
//        new Thread(new ThreadLocalDemo2()).start();
    }

    @Override
    public void run() {
        System.out.println(threadId.get());
    }
}
