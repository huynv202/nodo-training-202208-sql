package Unit8_Networking;

import java.io.IOException;
import java.net.*;

public class DatagramClientExample {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        byte []bytes = new byte[1000];
        bytes ="Client say Xin Chao".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length,address,4445);
        socket.send(packet);
        packet =new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);
        System.out.println("From server: "+new String(packet.getData(),0,packet.getLength()));
        socket.close();
    }
}
