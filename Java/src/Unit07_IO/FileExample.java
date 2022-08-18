package Unit07_IO;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("C:\\temp");

        System.out.println("This is "+(file.isFile()?"file":"folder"));
               File[] files = file.listFiles();
        for (File file1 : files ){
            System.out.println(file1.getName()+" : "+file1.length()+" bytes");
        }
//        if(file.isDirectory()){
//            System.out.println("This is folder");
//        }else{
//            System.out.println("This is file");
//        }
    }

}
