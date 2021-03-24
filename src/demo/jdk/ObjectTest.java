package demo.jdk;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ObjectTest {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Person stu1 = new Person("fo", 11);
        Person stu2 = new Person("fo", 22);
        map.put(stu1, "fo");
        map.put(stu2, "fo");

        // map判重的依据是 equals和hashcode都等于true.
        System.out.println(map.size());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
