package NODO_Traning_JV_Core_Basic2;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MessageFormatExample {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat( "EEEEE,dd MMMMM yyyy");

        String message = MessageFormat.format(
                "Hello{0}! Today is {1}.",args[0],
                dateFormat.format(Calendar.getInstance().getTime())

        );
        System.out.println(message);
    }
}
