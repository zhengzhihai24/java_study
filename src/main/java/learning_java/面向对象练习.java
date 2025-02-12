package learning_java;

import learning_java.entity.Person2;
import learning_java.entity.Student;

public class 面向对象练习 {
    public static void main(String[] args) {
        Student student1 = new Student(Student.status.INACTIVE);
        student1.study();
        student1.exam("数学");
        student1.read("语文");
        System.out.println(student1.getStatus().getStatus_desc());
        Student student2 = new Student("小明", 2, "BEIJING", Student.status.INACTIVE);

        student2.sayHello();


    }
}
