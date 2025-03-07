package learning_java.通信技术;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class 客户端 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            Scanner scanner = new Scanner(System.in);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
//                OutputStream outputStream = socket.getOutputStream();
//                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                System.out.print("你:");
                String line = scanner.nextLine();
                writer.write(line+"\r\n");
                writer.flush();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(reader.readLine());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("断开链接");
        }
    }

}
