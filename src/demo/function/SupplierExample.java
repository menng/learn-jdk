package demo.function;

import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Double> supplier = () -> Math.random();
        System.out.println(supplier.get());






    }
}
