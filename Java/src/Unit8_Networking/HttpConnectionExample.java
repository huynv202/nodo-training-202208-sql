package Unit8_Networking;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HttpConnectionExample {
    public static void main(String[] args) throws IOException {

            URL url = new URL("https://youtube.com");
            URLConnection connection =  url.openConnection();
//
        Path path = Paths.get("test1.html");

//            while ((read= stream.read(bytes))!=-1){
//                System.out.println(new String(bytes,0,read));
//            }
            try(InputStream inputStream = connection.getInputStream();
                    OutputStream outputStream= Files.newOutputStream(path, StandardOpenOption.CREATE,StandardOpenOption.APPEND)) {
                int read;
                byte []bytes = new byte[1000];
                while ((read = inputStream.read(bytes)) != -1) {
                   outputStream.write(bytes,0,read);

                }
            }finally {
                Desktop.getDesktop().open(path.toFile());
            }
    }
}
