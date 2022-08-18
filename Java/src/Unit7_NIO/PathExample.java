package Unit7_NIO;

import javax.sound.sampled.Line;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Filter;

public class PathExample {


    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Temp");
        Path path2 = path.resolve("count.txt");
        Charset charest = Charset.forName("utf8");
        try(BufferedReader reader = Files.newBufferedReader(path2,charest)) {
            String line=null;
            while ((line =reader.readLine())!=null){
                System.out.println(line);
            }

        }catch(Exception e) {
                e.printStackTrace();
        }
//        System.out.println("This is "+(Files.isDirectory(path)?"folder":"file"));
//        System.out.println(Files.exists(path));
//        Files.newDirectoryStream(path,".{java,txt}");
//        DirectoryStream.Filter<Path> fil=new DirectoryStream.Filter<Path>() {
//            @Override
//            public boolean accept(Path entry) throws IOException {
//                return entry.isAbsolute();
//            }
//        };

//
//             try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
//            for (Path p : directoryStream){
//                System.out.println(p.getFileName());
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
