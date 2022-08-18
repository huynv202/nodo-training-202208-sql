package Unit07_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectReaderStream {


    public static void main(String[] args) throws IOException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        File folder = new File("C:\\Temp");

       ObjectInputStream obi=new ObjectInputStream(new FileInputStream(new File(folder,"my_object")));

       Object obj = obi.readObject();
        Method method = obj.getClass().getMethod("run", new Class[0]);
        method.invoke(obj, new Object[0]);

    }
}
