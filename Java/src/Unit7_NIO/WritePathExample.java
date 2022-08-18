package Unit7_NIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

public class WritePathExample {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Temp\\count.txt");
        try (BufferedWriter writer= Files.newBufferedWriter(path,  Charset.forName("UTF-8"),CREATE,APPEND)){
            for (int i=0;i<5;i++){
                writer.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
