package NODO_Traning_JV_Core_Basic2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeFormatExample {
    public static void main(String[] args) {
        Locale locale = new Locale("vi","VI");
       DateFormat dateFormat = new SimpleDateFormat("EEEE,dd MMMMM yyyy",locale);
        Calendar calendar = Calendar.getInstance();
        System.out.println(dateFormat.format(calendar.getTime()));
    }
}
