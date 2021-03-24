package demo.jdk;

public class AbstractStringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(16);
        sb.append("12345679");
        sb.insert(2, "s");
        System.out.println(sb.toString());
        sb.setLength(18);
        System.out.println(sb.capacity());
        System.out.println(sb.length());

    }
}
