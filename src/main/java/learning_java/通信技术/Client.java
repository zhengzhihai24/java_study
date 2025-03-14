package learning_java.通信技术;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println(socket.getPort()+"已连接服务");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while (true) {
                String line = scanner.nextLine();
                bufferedWriter.write(line+"\r\n");
                bufferedWriter.flush();
                String response = bufferedReader.readLine();

                System.out.println(response);
            }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
