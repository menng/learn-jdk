package demo.function;

public class FunctionTest {
    public static void main(String[] args) {
        GreetingService greetingService = message -> System.out.println("Hello " + message);
        greetingService.sayMessage("message");
    }
}

interface GreetingService {
    void sayMessage(String message);
}
