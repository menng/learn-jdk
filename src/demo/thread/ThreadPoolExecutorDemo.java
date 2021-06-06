package demo.thread;

import java.util.concurrent.*;

/**
 * @author menng
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Callable<String> callable1 = () -> {
            Thread.sleep(5000);
            System.out.println("callable1方法执行了");
            return "callable1";
        };

        Callable<String> callable2 = () -> {
            Thread.sleep(3000);
            System.out.println("callable2方法执行了");
            return "callable2";
        };

        Future<String> submit1 = executorService.submit(callable1);
        Future<String> submit2 = executorService.submit(callable2);

        System.out.println("获取线程执行结果：" + submit1.get());
        System.out.println("获取线程执行结果：" + submit2.get());

//        System.out.println("获取线程执行结果：" + submit2.get());
//        System.out.println("获取线程执行结果：" + submit1.get());

        System.out.println("这是主线程");

        // 记得关闭线程池
        executorService.shutdown();
    }
}


