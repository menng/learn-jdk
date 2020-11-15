package demo.jdk;

import java.io.*;

public class JdkSerializable {
    public static void main(String[] args) throws Exception {
        Student s = new Student("kirito");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.db"));
        oos.writeObject(s);
        oos.close();

        ObjectInputStream oii = new ObjectInputStream(new FileInputStream("student.db"));
        Student ss = (Student) oii.readObject();
        assert "kirito".equals(ss.getName());
    }
}


class Student implements Serializable {
    private String name;

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
