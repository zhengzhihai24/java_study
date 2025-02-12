package learning_java.entity;

public class Person2 {
    String name;
    int age;
    String addres;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddres() {
        return addres;
    }


    public Person2(String name, int age, String addres) {
        this.name = name;
        this.age = age;
        this.addres = addres;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addres='" + addres + '\'' +
                '}';
    }

    public Person2() {
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public void sayHello() {
        System.out.println("Hello World");
    }
}