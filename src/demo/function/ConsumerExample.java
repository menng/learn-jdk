package demo.function;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> s = System.out::println;
        s.accept("hello consumer");

        Consumer<String> first = s1 -> System.out.println(s1.toLowerCase());
        Consumer<String> second = s2 -> System.out.println(s2.toUpperCase());

        Consumer<String> stringConsumer = first.andThen(second);
        stringConsumer.accept("Aaron");

        List<StudentC> list = createStudentList();

        Consumer<StudentC> studentConsumer = System.out::println;
        list.forEach(studentConsumer);
    }

    public static List<StudentC> createStudentList() {
        List<StudentC> studentList = new ArrayList<>();
        StudentC s1 = new StudentC(1, "Arpit", "M", 19);
        StudentC s2 = new StudentC(2, "John", "M", 17);
        StudentC s3 = new StudentC(3, "Mary", "F", 14);
        StudentC s4 = new StudentC(4, "Martin", "M", 21);
        StudentC s5 = new StudentC(5, "Monica", "F", 16);
        StudentC s6 = new StudentC(6, "Ally", "F", 20);

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);
        return studentList;
    }
}

class StudentC {

    private int id;
    private String name;
    private String gender;
    private int age;

    public StudentC(int id, String name, String gender, int age) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
    }
}
