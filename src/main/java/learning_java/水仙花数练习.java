package learning_java;

import java.util.ArrayList;

public class 水仙花数练习 {
    /*
    练习打印1000以内的水仙花数，加入到一个数组里面
     */

    public static void main(String[] args) {
        int start_range = 0;
        int end_range = 257;
        ArrayList list = new ArrayList();
        for (int i = start_range; i < end_range; i++) {
            if (isNarcissistic(i)) {
                list.add(i);
            }
        }
        System.out.println(list.toString());
    }
    public static boolean isNarcissistic(int number){
        String num = Integer.toString(number);
        int number_length = num.length();
        int sum = 0;
        for (int i = 0; i < number_length; i++) {
            int digit = num.charAt(i) - '0';
            sum += Math.pow(digit,number_length);
        }
        return sum ==number;
    }
}
