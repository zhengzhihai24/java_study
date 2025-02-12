package learning_java.util;

public interface Study {
    void study();
    default void read(String bookname) {
        System.out.println("正在阅读:"+bookname);
    }
    default void exam(String subject) {
        System.out.println("正在考试:"+subject);
    }

}
