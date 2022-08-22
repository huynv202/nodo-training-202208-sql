package Unit8_Networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;

public class TestHandler implements HttpHandler {




    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String messageFormat = "<html><h2>This is  the response</h2></html>";
        exchange.sendResponseHeaders(200,messageFormat.length());
         OutputStream out = exchange.getResponseBody();
        try(out){
            out.write(messageFormat.getBytes());

        }
    }
}
