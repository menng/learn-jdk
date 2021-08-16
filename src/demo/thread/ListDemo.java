package demo.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123abccd");
        list.add("abcdc123");
        list.add("1234abc");
        list.add("abc1234");
        list.add("abdc1234ww");

        List<String> collect = list.stream().sorted().collect(Collectors.toList());
        for(int i=0; i < collect.size(); i++) {
            for (int j=i+1; j < collect.size(); j++) {
                if (collect.get(j).replaceAll("[a-zA-Z]","" ).equals(collect.get(i).replaceAll("[a-zA-Z]","" ))) {
                    collect.remove(j);
                }
            }
        }

        System.out.println(collect);

    }
}
