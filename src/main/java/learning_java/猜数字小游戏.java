package learning_java;

import java.util.Scanner;

public class 猜数字小游戏 {
    public static void main(String[] args) {
//        int number ;
        int random = (int)(Math.random()*100)+1;
        Scanner sc = new Scanner(System.in);
//        number = sc.nextInt();
//        System.out.println(number);
        System.out.println("开始游戏,本轮数字是:"+random);
        while (true){
            System.out.println("请输入游戏:");
           int number = sc.nextInt();
            if(random<number){
                System.out.println("猜小了");
            } else if (random>number) {
                System.out.println("猜大了");
            }else {
                System.out.println("猜对了");
                break;
            }
        }
    }
}
