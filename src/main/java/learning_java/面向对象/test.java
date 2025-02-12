package learning_java.面向对象;

import learning_java.entity.Person2;

public class test {
    public static void main(String[] args) {
        //由于把Person改成了抽象类，因此临时使用的时候必须得做匿名内部类的方式，因此这里加上花括号表示实现了匿名内部类。
        Person person1 = new Person(){
            @Override
            public void sayHi() {
                System.out.println("匿名内部类实现");
            }
        };
        Person person2 = new Person("zzh",12,"shanghai"){
            @Override
            public void sayHi() {
            }
        };
        person1.sayHi();
        person1.setName("zzh");
        System.out.println(person1.getName());
        System.out.println(person2.toString());

        person1.sayHello();
        Person2 person3 = new Person2();
        person3.sayHello();

    }
}
