package learning_java.多线程;

public class 线程练习 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {    //直接编写逻辑
            for (int i = 0; i < 1000; i++) {
                System.out.println("我是线程1");
            }
        });
        t1.start();   //调用此方法来开始执行此线程

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("我是线程2");
                }
            }
        });
        t2.start();
    }

}
