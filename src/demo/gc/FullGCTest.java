package demo.gc;

import java.util.*;

public class FullGCTest {
    static String base = "base";
    public static void main(String[] args) {
        System.out.println("base".hashCode());
        System.out.println("base".hashCode()>>>16);
        System.out.println(3016401^46);


        Map<Integer, Integer> map = new HashMap<>();
        for(Map.Entry entry : map.entrySet()) {

        }

        Collection<Integer> collection = map.values();
        for(Integer integer: collection) {
            System.out.println();

        }
    }
}
