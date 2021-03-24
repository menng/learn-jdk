package demo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {

        String card = "1234567890987654321";

        int start = 10;
        int end = 5;
        int maskLeng = card.length() - start - end;
        char[] chars = card.toCharArray();

        int j = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < start; i++, j++) {
            sb.append(chars[j]);
        }

        for (int i=0; i < maskLeng; j++, i++) {
            sb.append("*");
        }

        for (int i=0; i < end; j++, i++) {
            sb.append(chars[j]);
        }

        System.out.println(sb.toString());



        List<String> list = new ArrayList<>();
        list.add("ss");
        list.add("ss");
        list.add("3333");
        list.stream()
                .filter(item -> item.equals("ss"))
                .filter(item -> item.equals("3333"))
                .limit(3)
//                .map(String::new)
                .forEach(System.out::println);
    }
}
