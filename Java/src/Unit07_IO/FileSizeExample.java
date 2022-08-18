package Unit07_IO;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FileSizeExample {
    private static long getSize(File file){
        if(file.isFile()){
            return file.length();
        }
        AtomicLong length =new AtomicLong(0);
        Arrays.stream(file.list()).forEach(f->{
            length.getAndSet(length.longValue());
        });
        return length.longValue();
    }

    public static void main(String[] args) {
        File file= new File("C:\\SQL2019\\re_filelist.snp");
        System.out.println(file.getParentFile());
        System.out.println("Size: " +getSize(file)/(1024)+"KB");
        System.out.println();
    }
}
