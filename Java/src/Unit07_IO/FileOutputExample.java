package Unit07_IO;

import java.io.*;

public class FileOutputExample {
    public static void main(String[] args) throws IOException {
        File file = new File("C:" + File.separator + "Temp" + File.separator + "count.txt");
        FileOutputStream outputStream = null;
//        try{
//            outputStream = new FileOutputStream(file);
//            String bytes = "Hello Ha Noi";
//            outputStream.write(bytes.getBytes());
//            System.out.println(bytes.getBytes());
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (outputStream!=null){
//                outputStream.close();
//            }
//        }
//        try(FileInputStream inputStream = new FileInputStream(file)) {
//            byte []bytes = new byte[16];
//            inputStream.read(bytes);
//            System.out.println(new String(bytes,"utf8"));
//        }

        try(FileInputStream inputStream = new FileInputStream(file)) {
            byte []bytes = new byte[4*1024];
            int read =-1;
            StringBuilder builder = new StringBuilder();
            while ((read=inputStream.read(bytes))!=-1){
                builder.append(new String(bytes, Integer.parseInt("0"),read));
            }
            System.out.println(builder);
        }
    }
}
