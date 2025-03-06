package learning_java;

import java.io.*;

public class 文件IO读取练习 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("testio.txt");
        //常规的循环读取，一个一个都，有很多IO
        try (FileInputStream inputStream = new FileInputStream(file)) {
            System.out.println(inputStream.available());
            int i ;
            while ((i = inputStream.read()) != -1) {
                System.out.print((char) i);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        //创建数组的方式读取
        try (FileInputStream inputStream2 = new FileInputStream(file)) {
            System.out.println(inputStream2.available());
            byte[] bytes = new byte[inputStream2.available()];//这里其实可以自己指定字节数的
            inputStream2.read(bytes);
            System.out.println(new String(bytes));
        }catch (Exception e){
            e.printStackTrace();
        }
        File file1 = new File("testioinput.txt");
        //文件输入流
        try (FileOutputStream fileOutputStream = new FileOutputStream(file1)) {
            fileOutputStream.write('c');
            fileOutputStream.write("lbwnb".getBytes());
            String str = " 给阿姨倒杯卡布奇诺";
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //利用输入流和输出流实现文件复制
        try (FileInputStream copyinput = new FileInputStream("D:/Downloads/次元_setup_4.1.5.exe");
             FileOutputStream copyoutput = new FileOutputStream("D:/Downloads/次元_setup_4.1.5(copy).exe")
        ) {
            System.out.println(copyinput.available());
            byte[] bytes = new byte[1024];
            int tmp;
            while ((tmp = copyinput.read(bytes))!=-1){
                copyoutput.write(bytes,0,tmp);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        //用FileRaader的方式读取
        try (FileReader fileReader = new FileReader(file)) {
            System.out.println("Filereader:"+ (char)fileReader.read());
        }catch (Exception e){
            e.printStackTrace();
        }

        //练习缓冲流读取数据
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            System.out.println("BufferedInputStream:"+(char)bufferedInputStream.read());
        }catch (Exception e){
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            System.out.println("BufferedReader:"+bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1))) {
            bufferedWriter.write("老八蜜汁小憨包");
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
