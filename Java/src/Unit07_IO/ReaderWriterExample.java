package Unit07_IO;

import java.awt.*;
import java.io.*;

public class ReaderWriterExample {
    public static void main(String[] args) throws IOException {
        File file =  new File("C:\\Temp\\count.txt");
        boolean append ;
//        try (FileWriter writer= new FileWriter(file, append = true)){
//            writer.write("\r\n");
//            writer.write("Tran Thi H");
//            Desktop.getDesktop().open(file);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        FileReader reader =null;
        reader = new FileReader(file);
        char[] buffer = new char[4*1024];
        int read =-1;
            StringBuilder builder= new StringBuilder();
            while ((read = reader.read(buffer))!=-1){
                builder.append(buffer,0,read);

            }
        System.out.println(builder);
    }
}
