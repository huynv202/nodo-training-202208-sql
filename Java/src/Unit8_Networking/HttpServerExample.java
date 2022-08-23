package Unit8_Networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class HttpServerExample {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
        TestHandler testHandler = new TestHandler();
        server.createContext("/test",testHandler);
        server.setExecutor(Executors.newFixedThreadPool(5));
        server.start();
        System.out.println("Server is running");
    }
}
