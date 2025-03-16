package learning_java.通信技术;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("服务器已启动，监听端口 8080...");

            while (true) { // 让服务器能处理多个请求
                Socket socket = server.accept();
                System.out.println("接收到连接: " + socket.getInetAddress());

                try (OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8")) {
                    String html = """
                    <!DOCTYPE html>
                    <html lang="zh">
                    <head>
                        <meta charset="UTF-8">
                        <title>测试网站</title>
                    </head>
                    <body>
                        <h1>欢迎访问我们的测试网站</h1>
                        <p>这个网站包含很多你喜欢的内容，但是没办法展示出来，因为我们还没学会。</p>
                    </body>
                    </html>
                    """;

                    // HTTP 响应头
                    writer.write("HTTP/1.1 200 OK\r\n");
                    writer.write("Content-Type: text/html; charset=UTF-8\r\n");
                    writer.write("Content-Length: " + html.getBytes("UTF-8").length + "\r\n"); // 明确指定内容长度
                    writer.write("\r\n"); // 必须有空行，分隔头部和正文
                    writer.write(html);
                    writer.flush();
                }

                socket.close(); // 关闭客户端连接
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
