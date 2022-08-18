package Unit7_NIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.FileVisitResult.*;

public class FileVisitorExample {
    public static  class PrintFiles extends SimpleFileVisitor<Path>{
        public FileVisitResult visitFile(){
            Path Path = null;
            System.out.println(!Files.isDirectory(Path) +"is file");
            return FileVisitResult.CONTINUE;
        }
        public FileVisitResult postVisitDirectory(){
            Path Path = null;
            System.out.println(Files.isDirectory(Path)+"is directory");
            return null;
        }



    }

    public static void main(String[] args) throws IOException {
        Path path =Paths.get("C:\\Temp");
        Files.walkFileTree(path,new PrintFiles());
    }
}
