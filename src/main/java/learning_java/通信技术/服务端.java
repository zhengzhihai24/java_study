package learning_java.通信技术;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class 服务端 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("等待链接");
            Socket socket = serverSocket.accept();
            String ip_address = socket.getInetAddress().getHostAddress();
            System.out.println("已连接,地址为:"+ ip_address);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String meassage ;
            while ((meassage = reader.readLine()) != null) {
                System.out.println(ip_address+":"+meassage);
                writer.write("发送成功"+"\r\n");
                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
