package learning_java;

public class 字符串对象 {
    public static void main(String[] args) {
        String str = "hello world";
        String[] split = str.split(" ");
        System.out.println(str.length());
        for (String s : split) {
            System.out.println(s);
        }

        StringBuilder stringBuilder = new StringBuilder().append(str);
        for (int i = 0; i <5; i++) {
            stringBuilder.append(i);
        }
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());
        System.out.println(stringBuilder.delete(0,2));


    }
}
