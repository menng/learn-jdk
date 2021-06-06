package demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * oom test
 * -Xms:20m -Xmx:20m
 */
public class OOMTest {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
