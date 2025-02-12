package learning_java.entity;

import learning_java.util.Study;

public class Student extends Person2 implements Study {


    private status currentStatus;
    @Override
    public void study() {
        System.out.println("去一班上课");
    }

    @Override
    public void sayHello() {
        super.sayHello();
        System.out.println("我叫:"+super.name);
    }
    public Student(){
    }

    public Student(String name, int age, String addres, status currentStatus) {
        super(name, age, addres);
        this.currentStatus = currentStatus;
    }

    // 添加一个构造函数来初始化状态
    public Student(status initialStatus) {
        this.currentStatus = initialStatus;
    }

    // 提供一个方法来设置状态
    public void setStatus(status newStatus) {
        this.currentStatus = newStatus;
    }

    // 提供一个方法来获取当前状态
    public status getStatus() {
        return currentStatus;
    }


    public enum status {
        ACTIVE(1,"活跃"),
        INACTIVE(0,"不活跃"),
        SLEEP(2,"睡眠");


        private final int code;
        private final String status_desc;

        status(int code, String status_desc) {
            this.code = code;
            this.status_desc = status_desc;
        }

        public int getCode() {
            return code;
        }

        public String getStatus_desc() {
            return status_desc;
        }
    }
}

