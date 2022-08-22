package Unit8_Networking;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class HttpHeaderExample {
    public static void main(String[] args) throws IOException {
        URL url=new URL("https://www.google.com.vn");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        System.out.println("http method"+connection.getRequestMethod());
        Map<String, List<String>> headers = connection.getHeaderFields();
        BiConsumer<String,List<String>>header =(key,value)->{
            System.out.println("Key"+key +"Value "+value);
        };
        headers.forEach(header);
    }
}
