package demo.jdk;

import java.math.BigDecimal;

public class LoveJava {
    public static void main(String[] args) {
        System.out.println("我爱读源码");
        System.out.println(1111<<1);
        System.out.println(1111>>1);
        System.out.println(Integer.toBinaryString((2^32)-1));

        System.out.println(new BigDecimal("1.3").subtract(new BigDecimal("0.1")).multiply(new BigDecimal(1000)).longValue());
    }
}