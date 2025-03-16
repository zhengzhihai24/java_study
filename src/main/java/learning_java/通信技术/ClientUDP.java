package learning_java.通信技术;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String str = scanner.nextLine();
                byte[] data = str.getBytes();
                InetAddress address = InetAddress.getByName("127.0.0.1");
                DatagramPacket datagramPacket = new DatagramPacket(data, data.length, address, 8080);
                datagramSocket.send(datagramPacket);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
