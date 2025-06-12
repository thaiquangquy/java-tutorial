package multi_threading.thread_local;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final ThreadLocal<DateFormat> dateFormat = new ThreadLocal<>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("dd-mm-yyyy");
        }
    };

    public static String formatDate(Date date) {
        return dateFormat.get().format(date);
    }

    public static void setDateFormat(String pattern) {
        dateFormat.set(new SimpleDateFormat(pattern));
    }
}
