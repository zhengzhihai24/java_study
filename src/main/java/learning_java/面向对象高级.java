package learning_java;

import learning_java.entity.Student;
import learning_java.util.Study;

public class 面向对象高级 {
    public static void main(String[] args) {
        Student student = new Student();
        student.study();

        Study study =() -> System.out.println("lambda练习");
        study.study();


    }
}
