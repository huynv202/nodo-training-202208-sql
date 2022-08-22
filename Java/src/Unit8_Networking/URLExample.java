package Unit8_Networking;

import java.net.MalformedURLException;
import java.net.URL;

public class URLExample {
    public static void main(String[] args) throws MalformedURLException {
        String link = "https://www.google.com.vn/search?q=hello";
        URL url = new URL(link);
        System.out.println("Protocool " +url.getProtocol());
        System.out.println("Port "+ url.getPort());
        System.out.println("Query "+ url.getQuery());
    }
}
