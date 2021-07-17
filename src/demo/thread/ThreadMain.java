package demo.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        System.out.println(Thread.currentThread().getPriority());

        List<Long> list = new ArrayList<>();
        list.add(100L);
        list.add(10000L);
        System.out.println(list.toString());

    }

}
