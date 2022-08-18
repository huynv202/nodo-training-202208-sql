package Unit7_NIO;

import java.nio.file.*;

public class FileFinderExample {
    public class Finder extends SimpleFileVisitor{
         PathMatcher matcher =  FileSystems.getDefault().getPathMatcher("glob:*.{txt}");
         public FileVisitResult visitResult() {


             return null;
         };

    }

    public static void main(String[] args) {
        Files.walkFileTree("C:\\Temp",Finder);
    }
}
