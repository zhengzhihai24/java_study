package learning_java.通信技术;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class ServiceUDP {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(8080)) {
            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
                socket.receive(datagramPacket);
                String hostAddress = datagramPacket.getAddress().getHostAddress();
                System.out.println(hostAddress+new String(datagramPacket.getData(),datagramPacket.getOffset(),datagramPacket.getLength()));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


}
