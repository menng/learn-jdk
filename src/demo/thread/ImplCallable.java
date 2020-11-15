package demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable
 */
public class ImplCallable implements Callable {
    @Override
    public String call() throws Exception {
        Thread.sleep(500L);

        System.out.println("这是线程C");
        return "ImplCallable Thread";
    }
}

class ThreadMainC {
    public static void main(String[] args) throws Exception{
        ImplCallable implCallable = new ImplCallable();
        FutureTask<String> feature = new FutureTask<>(implCallable);
        new Thread(feature).start();

        System.out.println("这是主线程：begin");
        System.out.println("得到的返回结果是：" + feature.get());
        System.out.println("这是主线程：end");
    }
}
