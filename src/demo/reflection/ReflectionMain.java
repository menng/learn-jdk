package demo.reflection;

public class ReflectionMain {
    public static void main(String[] args) throws Exception {
        ReflectionMain s = new ReflectionMain();
        Class<ReflectionMain> reflectionMainClass = ReflectionMain.class;
        Class<? extends ReflectionMain> aClass = s.getClass();
        Class<?> aClass1 = Class.forName("demo.reflection.ReflectionMain");
    }
}
