package learning_java.多线程;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

class Kitchen2{
    private final BlockingQueue<String> dishes;
    private final int maxSize;

    Kitchen2( int maxSize) {
        this.dishes = new LinkedBlockingDeque<>(maxSize);
        this.maxSize = maxSize;
        for (int i = 0; i < maxSize; i++) {
            dishes.add("菜");
        }
        System.out.println("开始营业,当前库存:" + dishes.size());
    }

    public void addDish(String ChefName) throws InterruptedException {
        synchronized (this) {
            if (!dishes.offer("菜", 1, TimeUnit.SECONDS)) {
                System.out.println("库存已满," + ChefName + "正在休息");
            } else {
                System.out.println(ChefName + "做了一道菜,当前库存为:" + dishes.size());
            }
//        dishes.put("菜");
        }
        Thread.sleep(3000);
    }

    public void eatDish(String CustomerName) throws InterruptedException {
        String dish;
        synchronized (this) {
            dish = dishes.poll(3, TimeUnit.SECONDS);
            if (dish != null) {
                System.out.println(CustomerName + "吃了一道菜,当前库存为:" + dishes.size());
            } else {
                System.out.println(CustomerName + "等太久了,走了");
            }
        }
        Thread.sleep(4000);
    }
}

class Chef2 implements Runnable{
    private final Kitchen2 kitchen;
    private final String ChefName;

    Chef2(Kitchen2 kitchen, String chefName) {
        this.kitchen = kitchen;
        ChefName = chefName;
    }

    @Override
    public void run() {
       try {
           while (true) {
               kitchen.addDish(ChefName);
           }
       }catch (Exception e){
           e.printStackTrace();
       }

    }
}

class Customer2 implements Runnable{
    private final Kitchen2 kitchen;
    private final String CustomerName;

    Customer2(Kitchen2 kitchen, String customerName) {
        this.kitchen = kitchen;
        CustomerName = customerName;
    }

    @Override
    public void run() {
        try{
            while (true) {
                kitchen.eatDish(CustomerName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

public class 线程模拟厨房线程安全版 {
    public static void main(String[] args) {
        Kitchen2 kitchen2 = new Kitchen2(10);
        new Thread(new Chef2(kitchen2,"厨师1")).start();
        new Thread(new Chef2(kitchen2,"厨师2")).start();
        new Thread(new Customer2(kitchen2,"客户1")).start();
        new Thread(new Customer2(kitchen2,"客户2")).start();
        new Thread(new Customer2(kitchen2,"客户3")).start();

    }
}
