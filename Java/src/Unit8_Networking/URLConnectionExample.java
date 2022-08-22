package Unit8_Networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;

public class URLConnectionExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://youtube.com");
        URLConnection connection = url.openConnection();
        InputStream stream = connection.getInputStream();
        int read;
        byte []bytes = new byte[0];
        while ((read= stream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,read));
        }

    }
}
