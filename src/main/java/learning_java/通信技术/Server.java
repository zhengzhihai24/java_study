package learning_java.通信技术;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            Socket socket = server.accept();
            String hostAddress = socket.getInetAddress().getHostAddress();
            System.out.println("已连接服务器:"+hostAddress);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(hostAddress+":"+line);
                bufferedWriter.write("服务器接收到你的消息："+line+"\r\n");
                bufferedWriter.flush();
            }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
