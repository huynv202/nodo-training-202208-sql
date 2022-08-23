package Unit8_Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class SocketClientExample {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6379);
System.out.println("Client is connected to "+socket.getInetAddress()+":"+socket.getPort());
        try(DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream())){
            output.writeUTF("Hello server");
            System.out.println("Client say: "+input.readUTF());
        }finally {
            socket.close();
        }
    }
}
