package Unit07_IO;

import java.awt.*;
import java.io.*;
import java.nio.channels.FileChannel;

public class CopyFileNIOExample {
    public static void main(String[] args)throws Exception {
        try{
            File sourceFile = new File("C:\\Temp\\count.txt");
            File desFile = new File(sourceFile.getParentFile() ,"count.txt");
            FileChannel srcChannel = null;
            FileChannel desChannel = null;
            srcChannel = new FileInputStream(sourceFile).getChannel();
            desChannel = new FileOutputStream(desFile).getChannel();
            srcChannel.transferTo(0,srcChannel.size(),desChannel);
            Desktop.getDesktop().open(sourceFile.getParentFile());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
