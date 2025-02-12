package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int a = 1;
        System.out.println(a);
        String str1 = "Hello";
        String str2 = "World";
        System.out.println(str1+str2+1.5);
        //老式的循环
         for (int i = 0; i <3; i++) {
             System.out.print(i);
         }
         int[] number = {1,2,3,4,5};
        //新式的增强for循环,只能用在数组或集合类上。
        for(int number2 : number){
            System.out.println(number2);
        }

    }
}