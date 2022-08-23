package Unit8_Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExample{

    public SocketServerExample( int serverPort) throws IOException {
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server is running on port "+serverPort);
        while(true){
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: "+socket.getInetAddress()+":"+socket.getPort());
            try(DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())){
                output.writeUTF("Hello client");
                System.out.println("Server say: "+input.readUTF());
            }finally {
                socket.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new SocketServerExample(6379);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
