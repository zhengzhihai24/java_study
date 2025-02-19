package learning_java;

import learning_java.entity.Book;

import java.util.LinkedList;
import java.util.Scanner;

public class 图书管理系统 {
    private static final   LinkedList<Book> list = new LinkedList<Book>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("-----------欢迎来到图书管理系统------------");
            System.out.println("1.录入数据");
            System.out.println("2.查看书籍");
            System.out.println("3.修改书籍");
            System.out.println("4.删除书籍");
            System.out.println("5.退出");
            System.out.println("----------------------------------------");
            System.out.println("请输入你要做的操作:");
            switch(scanner.nextLine()){
                case "5":
                    System.out.println("感谢使用，再见");
                    return;
                    case "1":
                        addBook(scanner);
                        System.out.println("添加完成");
                        break;
                    case "2":
                        System.out.println(list.toString());
                        System.out.println("查看");
                        break;
                    case "3":
                        System.out.println("修改完毕");
                        break;
                    case "4":
                        System.out.println("删除完毕");
                        break;

            }
        }

    }

    public static void addBook(Scanner scanner){
        System.out.print("请输入书名:");
        String title = scanner.nextLine();
        System.out.print("请输入作者:");
        String author = scanner.nextLine();
        System.out.print("请输入价格:");
        int price = scanner.nextInt();
        Book book = Book.builder().title(title).author(author).price(price).build();
        list.add(book);
    }
}
