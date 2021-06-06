package demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * oom test
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * java8开始使用本地内存了，此配置失效。
 */
public class OOMTest2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
