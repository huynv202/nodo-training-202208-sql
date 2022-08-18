package Unit07_IO;

import java.io.*;

public class ObjectWriterExample {
    public static void main(String[] args) throws IOException {
        File folder = new File("C:\\Temp");
        ObjectOutputStream objectOnputStream = null;
        FileOutputStream fileOutputStream = new FileOutputStream(new File(folder,"my_object"));
        objectOnputStream = new ObjectOutputStream(fileOutputStream);
        PrintMessage printMessage;
        objectOnputStream.writeObject(new PrintMessage("Can Noi Noi"));
    }
}
