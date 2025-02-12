package learning_java;

public class 异常捕获 {
    public static void main(String[] args) {
        try {
            Object o = null ;
            o.toString();
        }catch (Exception e){
            e.printStackTrace();
//            System.out.println(e.getMessage());
        }
        System.out.println("捕获完毕");
    }
}
