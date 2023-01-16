package ar.com.ada.backend12.employeeCrud.Utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Util {

    public Util() {
    }

    /**
     * Converts a String to a Date.
     * @param s The string to be converted to Date
     * @return If it was possible to parse it RETURN a DATE, if it was not possible to parse it RETURN NULL.
     */
    public Date parseDate(String s) {
        Date date = null;
        try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(s);
            System.out.println(date);
        } catch (ParseException e) {
            System.out.println("An ERROR occurred when trying to convert String to Date.");
            e.printStackTrace();
        }
        return date;
    }
}
