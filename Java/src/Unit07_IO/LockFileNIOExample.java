package Unit07_IO;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockFileNIOExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("C:\\Temp\\count.txt");
        RandomAccessFile raf = new RandomAccessFile(file,"rw");

        FileChannel channel = raf.getChannel();

        FileLock lock = channel.tryLock(0,Long.max(0,100),false);
        Desktop.getDesktop().edit(file);
        Thread.sleep(15*1000L);
        lock.release();
    }
}
