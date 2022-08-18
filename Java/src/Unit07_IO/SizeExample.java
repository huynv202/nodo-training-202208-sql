package Unit07_IO;

import java.io.File;

public class SizeExample {
    private static long getSize(File file){
        if(file.isFile()){
            return file.length();
        }
        File[] files = file.listFiles();
        int length=0;
        for (int i =0;i < file.length();i++){
            if(files[i].isDirectory()){
                length +=getSize(files[i]);
                continue;
            }
            length+=files[i].length();
        }
        return  length;
    }

    private static String getFileMB(File file){
        return (double) file.length()+"mb";
    }

    public static void main(String[] args) {
        File file = new File("D:\\Download\\MiniTool ShadowMaker");
        System.out.println("Size :" +getSize(file)/1024+"KB");
        System.out.println(getFileMB(file));
    }
}
