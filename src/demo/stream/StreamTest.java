package demo.stream;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
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

        List<Product> products = new ArrayList<>();
        products.add(new Product(100L));
        products.add(new Product(2000L));
        products.add(new Product(80L));
        Optional<Product> max = products.stream().max(Comparator.comparing(Product::getPrice));
        System.out.println( max.get().getPrice());

        LocalDateTime localDateTime = LocalDateTime.now().plusHours(3);
        long l = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(new Date((localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli() - System.currentTimeMillis())/60 + System.currentTimeMillis()));

        System.out.println("---");
        long s = 2001 / 100L;
        System.out.println(s);
    }
}

class Product {
    long price;

    public Product(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
