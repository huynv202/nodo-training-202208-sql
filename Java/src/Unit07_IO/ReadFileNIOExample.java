package Unit07_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileNIOExample {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Temp\\count.txt");
        FileInputStream fileInputStream =  null;
        FileChannel fileChannel = null;
        try{
            fileInputStream = new FileInputStream(file);
            fileChannel = fileInputStream.getChannel();
            long size = fileChannel.size();
            ByteBuffer buff = ByteBuffer.allocate((int)size);
            fileChannel.read(buff);
            buff.rewind();
            System.out.println(new String(buff.array(),"utf8"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(fileChannel!=null){
                fileChannel.close();
            }
            if (fileInputStream!=null){
                fileInputStream.close();
            }
        }
    }
}
