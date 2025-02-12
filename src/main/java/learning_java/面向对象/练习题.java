package learning_java.面向对象;

public class 练习题 {
    public static void main(String[] args) {

        System.out.println(frog_jump(5));

    }

//    青蛙跳台阶，斐波那契数列数学问题 f(n) = f(n-1)+f(n-2)
    public static int frog_jump(int n) {
        System.out.println(123);
        if (n == 1) return 1;  // 当n=1时，只有1种跳法
        if (n == 2) return 2;  // 当n=2时，有2种跳法
        int f1 = 2,f2 = 1,current = 0 ;
//        f(1) = 1 ,f(2) =2
        for (int i = 3; i <= n; i++) {
            current = f1 + f2;
            System.out.println(current);
            f2 = f1;
            f1 = current;
        }
        return current;

    }
}
