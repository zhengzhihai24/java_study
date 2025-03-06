package learning_java.多线程;

import java.util.LinkedList;
import java.util.Scanner;


class Kitchen{
    private final  LinkedList<String> dishes ;
    private final int maxSize = 10;

    Kitchen(int maxSize) {
        this.dishes = new LinkedList<>();
        for (int i = 0; i < maxSize; i++) {
            dishes.add("菜");
        }
        System.out.println("开始营业,当前库存:"+dishes.size());
    }

    public void addDish(String chefName) throws InterruptedException {
        synchronized (this) {
            while (dishes.size() >= maxSize) {
                System.out.println("货架已满:" + chefName + "等待中");
                wait();
            }
        }
         synchronized (this) {
        dishes.add("菜");
        System.out.println(chefName+"做了一道菜。"+"当前库存："+dishes.size());
        notifyAll();
         }
         //为避免长时间占用锁，等待时间放在外面。
        Thread.sleep(5000);
    }

    public void eatFood(String customerName) throws InterruptedException {
        synchronized (this) {
            while (dishes.isEmpty()) {
                System.out.println("没菜了" + customerName + "在等待");
                wait();
            }
        }

        synchronized (this) {
            dishes.removeFirst();
            System.out.println(customerName + "吃了一道菜,当前库存为:" + dishes.size());
            notifyAll();
        }
        Thread.sleep(3000);
    }
}

class Chef implements Runnable{
    private final Kitchen kitchen;
    private final String chefName;

    Chef(Kitchen kitchen, String chefName) {
        this.kitchen = kitchen;
        this.chefName = chefName;
    }

    @Override
    public void run() {
        try {
            while (true) {
                kitchen.addDish(chefName);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Customer implements Runnable{
    private final Kitchen kitchen;
    private final String customerName;

    Customer(Kitchen kitchen, String customerName) {
        this.kitchen = kitchen;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        try {
            while (true) {
                kitchen.eatFood(customerName);
            }
        }catch (Exception e) {
            System.out.println(customerName + " 停止进餐");
            e.printStackTrace();
        }
    }
}

public class 线程模拟厨房 {
    /**
     * 尝试练习模拟厨房，厨师和顾客，炒菜3秒，顾客吃菜4秒。
     * @param args
     */


    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen(10);
        new Thread(new Chef(kitchen,"厨师1"),"线程1").start();
        new Thread(new Chef(kitchen,"厨师2"),"线程2").start();

        new Thread(new Customer(kitchen,"客户1"),"客户线程1").start();
        new Thread(new Customer(kitchen,"客户2"),"客户线程2").start();
        new Thread(new Customer(kitchen,"客户3"),"客户线程3").start();


    }
}

