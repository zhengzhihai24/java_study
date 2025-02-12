package learning_java;


import java.util.ArrayList;

public class 数组类 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        System.out.println(list.toString());
        for(String str :list){
            System.out.println(str);
        }

    }
}
