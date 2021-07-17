package demo.function;


import java.util.List;

/**
 * 借助函数式接口，抽离出一个方法，使其满足这三个方法的实现逻辑
 */
public class FunctionPerson {

    public void searchPersonByGender(List<Person> list) {
        for(Person p: list) {
            if (Gender.FEMALE == p.getGender()) {
                System.out.println(p.getAddress());
            }
        }
    }

    public void searchPersonByAge(List<Student> list, int age) {
        for(Student p: list) {
            if (age == p.getAge()) {
                System.out.println(p.getAddress());
            }
        }
    }

    public void searchPersonByGenderMale(List<Teacher> list) {
        for(Teacher p: list) {
            if (Gender.MALE == p.getGender()) {
                System.out.println(p.getAddress());
            }
        }
    }

}


class Person {
    private int age;
    private String name;
    private String address;
    private Gender gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

class Student extends Person{}
class Teacher extends Person{}

enum Gender {
    MALE,
    FEMALE;
}
