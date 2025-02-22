package learning_java;

import learning_java.entity.Book;

import java.util.LinkedList;
import java.util.Scanner;

public class 图书管理系统 {
    private static final   LinkedList<Book> list = new LinkedList<Book>();
    public 图书管理系统(){
        list.add(new Book("Java编程思想", "Bruce Eckel", 99));
        list.add(new Book("深入理解Java虚拟机", "周志明", 79));
    }
    public void start() {
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
                        showBook();
                        System.out.println("查看");
                        break;
                    case "3":
                        updateBook(scanner);
                        System.out.println("修改完毕");
                        break;
                    case "4":
                        deleteBook(scanner);
                        System.out.println("删除完毕");
                        break;

            }
        }

    }

    public void showBook(){
        if(list.isEmpty()) {
            System.out.println("当前库中无书籍");
            return;
        }
        System.out.println(list.toString());
        int index = 1 ;
        for(Book book : list){
            System.out.printf("%d. 书名: %s, 作者: %s, 价格: %d%n", index, book.getTitle(), book.getAuthor(), book.getPrice());
            index++;
        }
    }

    public  void addBook(Scanner scanner){
        System.out.print("请输入书名:");
        String title = scanner.nextLine();
        System.out.print("请输入作者:");
        String author = scanner.nextLine();
        System.out.print("请输入价格:");
        int price = scanner.nextInt();
        Book book = Book.builder().title(title).author(author).price(price).build();
        list.add(book);
    }

    public void deleteBook(Scanner scanner){
        if(list.isEmpty()){
            System.out.println("没有书籍，无法删除");
            return;
        }
        showBook();
        System.out.println("请输入你要删除的书籍");
        int index  = scanner.nextInt();
        System.out.println("书籍已删除完成,删除的书籍为:"+list.get(index).getTitle());
        list.remove(index);
    }
    public void updateBook(Scanner scanner){
        if(list.isEmpty()){
            System.out.println("没有书籍，无法操作");
            return;
        }
        showBook();
        System.out.println("请输入你要编辑的书号:");
        int index = Integer.parseInt(scanner.nextLine());
        Book book = list.get(index);
        System.out.println("当前选中的书籍是:"+book);
        System.out.println("请选择要修改的内容:");
        System.out.println("1. 书名");
        System.out.println("2. 作者");
        System.out.println("3. 价格");
        System.out.print("请输入你的选择: ");
        String choice = scanner.nextLine();
        switch (choice){
            case "1":
                book.setTitle(scanner.nextLine());
                break;
            case "2":
                book.setAuthor(scanner.nextLine());
                break;
            case "3":
                book.setPrice(Integer.parseInt(scanner.nextLine()));
                break;
            default:
                System.out.println("无效选项！");
                return;
        }
        System.out.println("修改完成");

    }

    public static void main(String[] args) {
        图书管理系统 图书管理系统 = new 图书管理系统();
        图书管理系统.start();

    }
}
